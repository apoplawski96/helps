package com.helps.navigation

import android.util.Log
import com.helps.navigation.model.NavigationCommand
import com.helps.navigation.model.NavigationDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch


class HelpsNavigator(
    private val coroutineScope: CoroutineScope,
) : Navigator {

    override val commands: MutableSharedFlow<NavigationCommand> = MutableSharedFlow()

    override fun navigateBack() {
        emit(NavigationCommand.NavigateBack)
    }

    override fun navigate(
        destination: NavigationDestination,
        singleTop: Boolean,
    ) {
        emit(
            NavigationCommand.Navigate(
                destination = destination,
                singleTop = singleTop,
            )
        )
    }

    override fun popUpTo(
        destination: NavigationDestination,
        inclusive: Boolean,
        singleTop: Boolean,
        saveState: Boolean,
    ) {
        emit(
            NavigationCommand.PopUpTo(
                destination = destination,
                inclusive = inclusive,
                singleTop = singleTop,
                saveState = saveState,
            )
        )
    }

    private fun emit(command: NavigationCommand) {
        coroutineScope.launch {
            commands.emit(command)
        }
    }
}
