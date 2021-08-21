package com.helps.presentation.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.helps.presentation.HelpsBottomNavRoot
import com.helps.presentation.HelpsDestinations

@Composable
fun HelpsBottomNav(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    HelpsBottomNavigationBar(currentDestination = currentDestination) {
        onBottomNavItemClicked(navController, it)
    }
}

@Composable
private fun HelpsBottomNavigationBar(
    currentDestination: NavDestination?,
    onBottomNavClicked: (HelpsBottomNavRoot) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.background(MaterialTheme.colors.secondary)
    ) {
        HelpsDestinations.bottomNavigationScreens.forEach { screen ->
            BottomNavigationItem(
                label = { Text(text = screen.label) },
                selected = isRouteSelected(screen, currentDestination),
                onClick = { onBottomNavClicked(screen) },
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.label) }
            )
        }
    }
}

private fun isRouteSelected(
    destination: HelpsBottomNavRoot,
    currentDestination: NavDestination?,
) = currentDestination?.hierarchy?.any { it.route == destination.route } == true

private fun onBottomNavItemClicked(
    navController: NavController,
    destination: HelpsBottomNavRoot,
) {
    navController.navigate(destination.route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
@Preview
private fun HelpsBottomNavPreview() {
    HelpsBottomNavigationBar(
        currentDestination = null,
        onBottomNavClicked = { }
    )
}