package com.helps.navigation.model

sealed class NavigationCommand {

    object NavigateBack : NavigationCommand()

    class Navigate(
        val destination: NavigationDestination,
        val singleTop: Boolean,
    ) : NavigationCommand()

    class PopUpTo(
        val destination: NavigationDestination,
        val inclusive: Boolean,
        val singleTop: Boolean,
        val saveState: Boolean,
    ) : NavigationCommand()

    val route: String
        get() = when (this) {
            is NavigateBack -> ""
            is Navigate -> this.destination.route
            is PopUpTo -> this.destination.route
        }
}
