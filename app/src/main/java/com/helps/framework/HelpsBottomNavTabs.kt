package com.helps.framework

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class HelpsBottomNavTab(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val destinationScreens: List<HelpsScreen>
) {
    HOME(
        route = "home_bottom_nav_root",
        label = "Home",
        icon = Icons.Filled.Home,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.homeScreen)
    ),
    ACTIVE_HELPS(
        route = "active_helps_bottom_nav_root",
        label = "Active",
        icon = Icons.Filled.NotificationsActive,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.activeHelpsScreen)
    ),
    PENDING_HELPS(
        route = "pending_helps_bottom_nav_root",
        label = "Pending",
        icon = Icons.Filled.Pending,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.pendingHelpsScreen),
    ),
    SETTINGS(
        route = "settings_bottom_nav_root",
        label = "settings",
        icon = Icons.Filled.Settings,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.settingsScreen)
    );

    companion object {

        fun getRoutesList(): List<String> = values()
            .flatMap { it.destinationScreens }
            .map { it.route }

        private fun siema() {

        }
    }
}