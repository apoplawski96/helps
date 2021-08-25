package com.helps.framework

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.systemuicontroller.SystemUiController
import com.helps.presentation.helps.active.HelpsActiveScreen
import com.helps.presentation.helps.add.HelpsAddNewScreen
import com.helps.presentation.helps.pending.HelpsPendingScreen
import com.helps.presentation.home.HelpsHomeScreen
import com.helps.presentation.profile.HelpsUserProfileScreen
import com.helps.presentation.start.auth.guest.HelpsGuestScreen
import com.helps.presentation.start.auth.user.HelpsCreateAccountScreen
import com.helps.presentation.start.welcome.HelpsWelcomeScreen

@ExperimentalAnimationApi
@Composable
fun HelpsNavHost(navController: NavHostController, systemUiController: SystemUiController) {

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(Color.Black)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = HelpsDestinations.StartSection.startScreen.route,
        modifier = Modifier.fillMaxSize(),
        enterTransition = { _, _ ->
            slideInHorizontally(initialOffsetX = { 1000 })
        },
        exitTransition = { _, _ ->
            slideOutHorizontally(targetOffsetX = { -1000 })
        }
    ) {
        helpsStartScreen(
            builder = this,
            navController = navController
        )
        helpsGuestScreen(
            builder = this,
            navController = navController
        )
        helpsCreateAccountScreen(
            builder = this,
            navController = navController
        )

        helpsHomeScreenBottomNavRoot(
            builder = this,
            navController = navController
        )
        helpsActiveScreenBottomNavRoot(
            builder = this,
            navController = navController
        )
        helpsPendingScreenBottomNavRoot(
            builder = this,
            navController = navController
        )
        helpsSettingsScreenBottomNavRoot(
            builder = this,
            navController = navController
        )

        helpsAddScreen(
            builder = this,
            navController = navController
        )
        helpsSearchScreen(
            builder = this,
            navController = navController
        )
    }
}

@ExperimentalAnimationApi
private fun helpsHomeScreenBottomNavRoot(
    builder: NavGraphBuilder,
    navController: NavHostController
) {
    builder.navigation(
        startDestination = HelpsDestinations.MainSection.BottomNavSection.homeScreen.route,
        route = HelpsDestinations.BottomNavRoots.home.route
    ) {
        composable(
            route = HelpsDestinations.MainSection.BottomNavSection.homeScreen.route,
        ) {
            HelpsHomeScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun helpsActiveScreenBottomNavRoot(
    builder: NavGraphBuilder,
    navController: NavHostController
) {
    builder.navigation(
        startDestination = HelpsDestinations.MainSection.BottomNavSection.activeHelpsScreen.route,
        route = HelpsDestinations.BottomNavRoots.active.route
    ) {
        composable(HelpsDestinations.MainSection.BottomNavSection.activeHelpsScreen.route) {
            HelpsActiveScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun helpsPendingScreenBottomNavRoot(
    builder: NavGraphBuilder,
    navController: NavHostController
) {
    builder.navigation(
        startDestination = HelpsDestinations.MainSection.BottomNavSection.pendingHelpsScreen.route,
        route = HelpsDestinations.BottomNavRoots.pending.route
    ) {
        composable(HelpsDestinations.MainSection.BottomNavSection.pendingHelpsScreen.route) {
            HelpsPendingScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun helpsSettingsScreenBottomNavRoot(
    builder: NavGraphBuilder,
    navController: NavHostController
) {
    builder.navigation(
        startDestination = HelpsDestinations.MainSection.BottomNavSection.settingsScreen.route,
        route = HelpsDestinations.BottomNavRoots.settings.route
    ) {
        composable(HelpsDestinations.MainSection.BottomNavSection.settingsScreen.route) {
            HelpsUserProfileScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun helpsStartScreen(
    builder: NavGraphBuilder,
    navController: NavController
) {
    builder.composable(
        route = HelpsDestinations.StartSection.startScreen.route
    ) {
        HelpsWelcomeScreen(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun helpsGuestScreen(
    builder: NavGraphBuilder,
    navController: NavController
) {
    builder.composable(
        route = HelpsDestinations.StartSection.guestScreen.route
    ) {
        HelpsGuestScreen(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun helpsCreateAccountScreen(
    builder: NavGraphBuilder,
    navController: NavController
) {
    builder.composable(
        route = HelpsDestinations.StartSection.createAccountScreen.route
    ) {
        HelpsCreateAccountScreen(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun helpsAddScreen(
    builder: NavGraphBuilder,
    navController: NavController
) {
    builder.composable(
        route = HelpsDestinations.MainSection.addHelpsScreen.route
    ) {
        HelpsAddNewScreen(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun helpsSearchScreen(
    builder: NavGraphBuilder,
    navController: NavController
) {
    builder.composable(
        route = HelpsDestinations.MainSection.searchHelpsScreen.route
    ) {
        HelpsAddNewScreen(navController = navController)
    }
}