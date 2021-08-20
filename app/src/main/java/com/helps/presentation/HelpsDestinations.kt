package com.helps.presentation

import androidx.navigation.compose.NamedNavArgument

interface HelpsScreen {

    val route: String
    val arguments: List<NamedNavArgument>
}

interface HelpsBottomNavScreen : HelpsScreen {

    val label: String
}

object HelpsDestinations {

    val startScreen = StartScreen
    val guestScreen = GuestScreen
    val createAccountScreen = CreateAccountScreen
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