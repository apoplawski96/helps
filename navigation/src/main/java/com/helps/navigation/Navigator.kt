package com.helps.navigation

import com.helps.navigation.model.NavigationCommand
import com.helps.navigation.model.NavigationDestination
import kotlinx.coroutines.flow.SharedFlow

interface Navigator {

    val commands: SharedFlow<NavigationCommand>

    fun navigateBack()

    fun navigate(
        destination: NavigationDestination,
        singleTop: Boolean = true,
    )

    fun popUpTo(
        destination: NavigationDestination,
        inclusive: Boolean = false,
        singleTop: Boolean = true,
        saveState: Boolean = false,
    )
}
