package com.helps.navigation.model

interface BottomNavItem {

    val route: String
    val label: String
    val iconResId: Int
    val destinationScreens: List<NavigationDestination>
}
