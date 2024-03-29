package com.helps.app.ui

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
import com.helps.app.ui.auth.create.HelpsCreateAccountScreen
import com.helps.app.ui.auth.guest.HelpsGuestScreen
import com.helps.app.ui.auth.login.HelpsLoginScreen
import com.helps.app.ui.auth.user.LocalUserState
import com.helps.app.ui.helps.active.HelpsActiveScreen
import com.helps.app.ui.helps.add.AddHelpsScreen
import com.helps.app.ui.helps.detail.HelpsDetailScreen
import com.helps.app.ui.helps.pending.HelpsPendingScreen
import com.helps.app.ui.helps.search.SearchHelpsScreen
import com.helps.app.ui.home.HelpsHomeScreen
import com.helps.app.ui.profile.HelpsUserProfileScreen
import com.helps.app.ui.start.welcome.HelpsWelcomeScreen
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
        helpsStartScreen()
        helpsGuestScreen(navController = navController)
        helpsCreateAccountScreen()
        helpsLoginScreen()

        helpsHomeScreenBottomNavRoot()
        helpsActiveScreenBottomNavRoot()
        helpsPendingScreenBottomNavRoot()
        helpsSettingsScreenBottomNavRoot()

        helpsAddScreen()
        helpsSearchScreen()
        helpsDetailScreen()
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
private fun NavGraphBuilder.helpsHomeScreenBottomNavRoot() {
    navigation(
        startDestination = HomeScreen.route,
        route = HelpsDestinations.BottomNavRoots.home.route
    ) {
        composable(
            route = HomeScreen.route,
        ) {
            HelpsHomeScreen(viewModel = hiltViewModel())
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsActiveScreenBottomNavRoot() {
    navigation(
        startDestination = ActiveHelpsScreen.route,
        route = HelpsDestinations.BottomNavRoots.active.route
    ) {
        composable(ActiveHelpsScreen.route) {
            HelpsActiveScreen()
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsPendingScreenBottomNavRoot() {
    navigation(
        startDestination = PendingHelpsScreen.route,
        route = HelpsDestinations.BottomNavRoots.pending.route
    ) {
        composable(PendingHelpsScreen.route) {
            HelpsPendingScreen()
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsSettingsScreenBottomNavRoot() {
    navigation(
        startDestination = SettingsScreen.route,
        route = HelpsDestinations.BottomNavRoots.settings.route
    ) {
        composable(SettingsScreen.route) {
            HelpsUserProfileScreen(viewModel = hiltViewModel())
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsStartScreen() {
    composable(
        route = StartScreen.route
    ) {
        HelpsWelcomeScreen(viewModel = hiltViewModel())
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
private fun NavGraphBuilder.helpsLoginScreen() {
    composable(
        route = LoginScreen.route
    ) {
        HelpsLoginScreen(
            viewModel = hiltViewModel()
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsAddScreen() {
    composable(
        route = AddHelpsScreen.route
    ) {
        AddHelpsScreen(viewModel = hiltViewModel())
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsSearchScreen() {
    composable(
        route = SearchHelpsScreen.route
    ) {
        SearchHelpsScreen(viewModel = hiltViewModel())
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.helpsDetailScreen() {
    composable(
        route = HelpsDetailScreen.route,
    ) {
        val helpsId = it.arguments?.getString(HelpsDetailScreen.ID_ARG_KEY)
        HelpsDetailScreen(viewModel = hiltViewModel(), helpsId = helpsId)
    }
}