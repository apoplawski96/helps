package com.helps.navigation.model

import androidx.navigation.NamedNavArgument

interface NavigationDestination {

    val route: String
    val arguments: List<NamedNavArgument>
}

fun navigationDestinationOf(
    route: String,
    arguments: List<NamedNavArgument> = emptyList()
) = object : NavigationDestination {
    override val route: String = route
    override val arguments: List<NamedNavArgument> = arguments
}