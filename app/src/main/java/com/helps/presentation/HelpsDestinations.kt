package com.helps.presentation

import androidx.navigation.NamedNavArgument

interface HelpsScreen {

    val route: String
    val arguments: List<NamedNavArgument>
}

object HelpsDestinations {

    object StartSection {

        val startScreen = StartScreen
        val guestScreen = GuestScreen
        val loginScreen = LoginScreen
        val createAccountScreen = CreateAccountScreen
    }

    object MainSection {

        object BottomNavSection {

            val homeScreen = HomeScreen
            val activeHelpsScreen = ActiveHelpsScreen
            val pendingHelpsScreen = PendingHelpsScreen
            val settingsScreen = SettingsScreen
        }

        val addHelpsScreen = AddHelpsScreen
        val searchHelpsScreen = SearchHelpsScreen
    }

    object BottomNavRoots {

        val home = HelpsBottomNavTab.HOME
        val active = HelpsBottomNavTab.ACTIVE_HELPS
        val pending = HelpsBottomNavTab.PENDING_HELPS
        val settings = HelpsBottomNavTab.SETTINGS
    }
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

object LoginScreen : HelpsScreen {

    override val route: String
        get() = "login_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object HomeScreen : HelpsScreen {

    override val route: String
        get() = "home_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object ActiveHelpsScreen : HelpsScreen {

    override val route: String
        get() = "active_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object PendingHelpsScreen : HelpsScreen {

    override val route: String
        get() = "pending_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object SettingsScreen : HelpsScreen {

    override val route: String
        get() = "user_profile_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object AddHelpsScreen : HelpsScreen {

    override val route: String
        get() = "add_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object SearchHelpsScreen : HelpsScreen {

    override val route: String
        get() = "search_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}