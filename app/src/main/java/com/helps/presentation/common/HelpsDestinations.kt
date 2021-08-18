package com.helps.presentation.common

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