package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.helps.framework.HelpsBottomNavTab

@Composable
fun HelpsBottomNav(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    HelpsBottomNav(currentDestination = currentDestination, onBottomNavClicked = {
        onBottomNavItemClicked(
            navController = navController,
            destination = it
        )
    })
}

@Composable
private fun HelpsBottomNav(
    currentDestination: NavDestination?,
    onBottomNavClicked: (HelpsBottomNavTab) -> Unit
) {
    val bottomNavRoutesList = HelpsBottomNavTab.getRoutesList()
    val currentRoute = currentDestination?.route

    Column {
        if (currentRoute in bottomNavRoutesList) {
            HelpsBottomNavigationBar(
                currentDestination = currentDestination,
                onBottomNavClicked = onBottomNavClicked
            )
        }
        SystemNavigationBarOffset()
    }
}

@Composable
private fun HelpsBottomNavigationBar(
    currentDestination: NavDestination?,
    onBottomNavClicked: (HelpsBottomNavTab) -> Unit
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.onSecondary,
        modifier = Modifier.height(64.dp)
    ) {
        HelpsBottomNavTab.values().forEach { bottomNavTab ->
            BottomNavigationItem(
                label = { Text(text = bottomNavTab.label) },
                selected = isRouteSelected(bottomNavTab, currentDestination),
                onClick = { onBottomNavClicked(bottomNavTab) },
                icon = {
                    Icon(
                        imageVector = bottomNavTab.icon,
                        contentDescription = bottomNavTab.label
                    )
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .align(CenterVertically)
            )
        }
    }
}

@Composable
private fun SystemNavigationBarOffset() {
    Spacer(modifier = Modifier.height(44.dp))
}

private fun isRouteSelected(
    destination: HelpsBottomNavTab,
    currentDestination: NavDestination?,
) = currentDestination?.hierarchy?.any { it.route == destination.route } == true

private fun onBottomNavItemClicked(
    navController: NavController,
    destination: HelpsBottomNavTab,
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