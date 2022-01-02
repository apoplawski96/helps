package com.helps.app.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.helps.navigation.model.NavigationDestination
import com.helps.navigation.model.navigationDestinationOf

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
        val helpsDetailScreen = HelpsDetailScreen
    }

    object BottomNavRoots {

        val home = HelpsBottomNavTab.HOME
        val active = HelpsBottomNavTab.ACTIVE_HELPS
        val pending = HelpsBottomNavTab.PENDING_HELPS
        val settings = HelpsBottomNavTab.SETTINGS
    }
}

object StartScreen : NavigationDestination {

    override val route: String
        get() = "start_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object GuestScreen : NavigationDestination {

    override val route: String
        get() = "guest_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object CreateAccountScreen : NavigationDestination {

    override val route: String
        get() = "create_account_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object LoginScreen : NavigationDestination {

    override val route: String
        get() = "login_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object HomeScreen : NavigationDestination {

    override val route: String
        get() = "home_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object ActiveHelpsScreen : NavigationDestination {

    override val route: String
        get() = "active_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object PendingHelpsScreen : NavigationDestination {

    override val route: String
        get() = "pending_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object SettingsScreen : NavigationDestination {

    override val route: String
        get() = "user_profile_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object AddHelpsScreen : NavigationDestination {

    override val route: String
        get() = "add_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object SearchHelpsScreen : NavigationDestination {

    override val route: String
        get() = "search_helps_screen"
    override val arguments: List<NamedNavArgument>
        get() = listOf()
}

object HelpsDetailScreen : NavigationDestination {

    const val ID_ARG_KEY = "id"

    override val route: String
        get() = "helps_detail_screen/{$ID_ARG_KEY}"
    override val arguments: List<NamedNavArgument>
        get() = listOf(navArgument(ID_ARG_KEY) { type = NavType.StringType })

    fun destination(id: String) = navigationDestinationOf(
        route = "helps_detail_screen/$id",
        arguments = arguments
    )
}