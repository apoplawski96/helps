package com.helps.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NamedNavArgument

interface HelpsScreen {

    val route: String
    val arguments: List<NamedNavArgument>
}

interface HelpsBottomNavRoot : HelpsScreen {

    val label: String
    val icon: ImageVector
}

object HelpsDestinations {

    val startScreen = StartScreen
    val guestScreen = GuestScreen
    val createAccountScreen = CreateAccountScreen

    val homeBottomNavRoot: HelpsBottomNavRoot = HomeBottomNavRoot
    val homeScreen = HomeScreen

    val activeHelpsBottomNavRoot: HelpsBottomNavRoot = ActiveHelpsBottomNavRoot
    val activeHelpsScreen = ActiveHelpsScreen

    val pendingHelpsBottomNavRoot: HelpsBottomNavRoot = PendingHelpsBottomNavRoot
    val pendingHelpsScreen = PendingHelpsScreen

    val userProfileBottomNavRoot: HelpsBottomNavRoot = UserProfileBottomNavRoot
    val userProfileScreen = UserProfileScreen

    val bottomNavigationScreens = listOf(
        homeBottomNavRoot,
        activeHelpsBottomNavRoot,
        pendingHelpsBottomNavRoot,
        userProfileBottomNavRoot
    )
}

object StartScreen : HelpsScreen {

    override val route: String
        get() = "start_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object GuestScreen : HelpsScreen {

    override val route: String
        get() = "guest_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object CreateAccountScreen : HelpsScreen {

    override val route: String
        get() = "create_account_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object HomeBottomNavRoot : HelpsBottomNavRoot {

    override val label: String
        get() = "Home"
    override val icon: ImageVector
        get() = Icons.Filled.Home
    override val route: String
        get() = "home_bottom_nav_root"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object HomeScreen : HelpsScreen {

    override val route: String
        get() = "home_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object ActiveHelpsBottomNavRoot : HelpsBottomNavRoot {

    override val label: String
        get() = "Active"
    override val icon: ImageVector
        get() = Icons.Filled.LocationOn
    override val route: String
        get() = "active_helps_bottom_nav_root"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object ActiveHelpsScreen : HelpsScreen {

    override val route: String
        get() = "active_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object PendingHelpsBottomNavRoot : HelpsBottomNavRoot {

    override val label: String
        get() = "Pending"
    override val icon: ImageVector
        get() = Icons.Filled.LockClock
    override val route: String
        get() = "pending_helps_bottom_nav_root"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object PendingHelpsScreen : HelpsScreen {

    override val route: String
        get() = "pending_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object UserProfileBottomNavRoot : HelpsBottomNavRoot {

    override val label: String
        get() = "Profile"
    override val icon: ImageVector
        get() = Icons.Filled.Person
    override val route: String
        get() = "user_profile_bottom_nav_root"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object UserProfileScreen : HelpsScreen {

    override val route: String
        get() = "user_profile_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}