package com.helps.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.More
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PendingActions
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
        icon = Icons.Outlined.Home,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.homeScreen)
    ),
    ACTIVE_HELPS(
        route = "active_helps_bottom_nav_root",
        label = "Active",
        icon = Icons.Outlined.Notifications,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.activeHelpsScreen)
    ),
    PENDING_HELPS(
        route = "pending_helps_bottom_nav_root",
        label = "Pending",
        icon = Icons.Outlined.PendingActions,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.pendingHelpsScreen),
    ),
    SETTINGS(
        route = "settings_bottom_nav_root",
        label = "settings",
        icon = Icons.Outlined.More,
        destinationScreens = listOf(HelpsDestinations.MainSection.BottomNavSection.settingsScreen)
    );

    companion object {

        fun getRoutesList(): List<String> = values()
            .flatMap { it.destinationScreens }
            .map { it.route }
    }
}