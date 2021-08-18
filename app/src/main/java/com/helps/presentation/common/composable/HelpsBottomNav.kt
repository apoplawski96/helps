package com.helps.presentation.common.composable

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.helps.presentation.common.HelpsBottomNavScreen

@Composable
fun HelpsBottomNav(
    navController: NavController,
    items: List<HelpsBottomNavScreen>
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                label = { Text(text = screen.label) },
                selected = isRouteSelected(screen, currentDestination),
                onClick = { onBottomNavItemClicked(navController, screen) },
                // TODO - replace icons
                icon = { Icon(Icons.Filled.Favorite, contentDescription = screen.label) }
            )
        }
    }
}

private fun isRouteSelected(
    destination: HelpsBottomNavScreen,
    currentDestination: NavDestination?,
): Boolean = currentDestination?.hierarchy?.any { it.route == destination.route } == true

private fun onBottomNavItemClicked(
    navController: NavController,
    destination: HelpsBottomNavScreen,
) {
    navController.navigate(destination.route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}