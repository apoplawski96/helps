package com.helps.app.presentation

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.helps.app.presentation.auth.create.HelpsCreateAccountScreen
import com.helps.app.presentation.auth.guest.HelpsGuestScreen
import com.helps.app.presentation.auth.login.HelpsLoginScreen
import com.helps.app.presentation.auth.user.LocalUserState
import com.helps.app.presentation.helps.active.HelpsActiveScreen
import com.helps.app.presentation.helps.add.HelpsAddNewScreen
import com.helps.app.presentation.helps.pending.HelpsPendingScreen
import com.helps.app.presentation.helps.search.HelpsSearchScreen
import com.helps.app.presentation.home.HelpsHomeScreen
import com.helps.app.presentation.profile.HelpsUserProfileScreen
import com.helps.app.presentation.start.welcome.HelpsWelcomeScreen
import com.helps.navigation.Navigator
import com.helps.navigation.model.NavigationCommand
import kotlinx.coroutines.flow.collect

@ExperimentalAnimationApi
@Composable
fun HelpsNavHost(
    navController: NavHostController,
    navigator: Navigator
) {
    LaunchedEffect(key1 = null) {
        navigator.commands.collect() { navigationCommand ->
            handleNavigationCommand(navigationCommand, navController)
        }
    }

    // TODO: This feels sketchy, refactor/investigate later
    val helpsUser = LocalUserState.current.user.collectAsState().value

    val startDestination = if (helpsUser == null) {
        StartScreen.route
    } else {
        HelpsDestinations.BottomNavRoots.home.route
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize(),
        enterTransition = { _, _ ->
            fadeIn(initialAlpha = 0.5f)
        },
    ) {
        helpsStartScreen(
            navController = navController
        )
        helpsGuestScreen(
            navController = navController
        )
        helpsCreateAccountScreen()
        helpsLoginScreen(
            navController = navController
        )

        helpsHomeScreenBottomNavRoot(
            navController = navController
        )
        helpsActiveScreenBottomNavRoot(
            navController = navController
        )
        helpsPendingScreenBottomNavRoot(
            navController = navController
        )
        helpsSettingsScreenBottomNavRoot(
            navController = navController
        )

        helpsAddScreen(
            navController = navController
        )
        helpsSearchScreen(
            navController = navController
        )
    }
}

private fun handleNavigationCommand(
    command: NavigationCommand,
    navController: NavHostController
) {
    if (command.route.isEmpty() && command !is NavigationCommand.NavigateBack) return

    when (command) {
        is NavigationCommand.NavigateBack -> {
            navController.popBackStack()
        }
        is NavigationCommand.Navigate -> {
            navController.navigate(route = command.route) {
                launchSingleTop = command.singleTop
            }
        }
        is NavigationCommand.PopUpTo -> {
            navController.navigate(route = command.route) {
                launchSingleTop = command.singleTop
                restoreState = command.saveState
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = command.inclusive
                    saveState = command.saveState
                }
            }
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsHomeScreenBottomNavRoot(
    navController: NavHostController
) {
    navigation(
        startDestination = HomeScreen.route,
        route = HelpsDestinations.BottomNavRoots.home.route
    ) {
        composable(
            route = HomeScreen.route,
        ) {
            HelpsHomeScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsActiveScreenBottomNavRoot(
    navController: NavHostController
) {
    navigation(
        startDestination = ActiveHelpsScreen.route,
        route = HelpsDestinations.BottomNavRoots.active.route
    ) {
        composable(ActiveHelpsScreen.route) {
            HelpsActiveScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsPendingScreenBottomNavRoot(
    navController: NavHostController
) {
    navigation(
        startDestination = PendingHelpsScreen.route,
        route = HelpsDestinations.BottomNavRoots.pending.route
    ) {
        composable(PendingHelpsScreen.route) {
            HelpsPendingScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsSettingsScreenBottomNavRoot(
    navController: NavHostController
) {
    navigation(
        startDestination = SettingsScreen.route,
        route = HelpsDestinations.BottomNavRoots.settings.route
    ) {
        composable(SettingsScreen.route) {
            HelpsUserProfileScreen(navController = navController, viewModel = hiltViewModel())
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsStartScreen(
    navController: NavController
) {
    composable(
        route = StartScreen.route
    ) {
        HelpsWelcomeScreen(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsGuestScreen(
    navController: NavController
) {
    composable(
        route = GuestScreen.route
    ) {
        HelpsGuestScreen(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsCreateAccountScreen() {
    composable(
        route = CreateAccountScreen.route
    ) {
        HelpsCreateAccountScreen(
            viewModel = hiltViewModel()
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsLoginScreen(
    navController: NavController,
) {
    composable(
        route = LoginScreen.route
    ) {
        HelpsLoginScreen(
            navController = navController,
            viewModel = hiltViewModel()
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsAddScreen(
    navController: NavController
) {
    composable(
        route = AddHelpsScreen.route
    ) {
        HelpsAddNewScreen(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsSearchScreen(
    navController: NavController
) {
    composable(
        route = SearchHelpsScreen.route
    ) {
        HelpsSearchScreen(navController = navController)
    }
}