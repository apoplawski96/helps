package com.helps.presentation.common.composable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.helps.presentation.HelpsDestinations
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
fun HelpsNavHost() {
    val navController = rememberAnimatedNavController()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(Color.Black)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = HelpsDestinations.homeBottomNavRoot.route,
        modifier = Modifier.fillMaxSize()
    ) {
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
        helpsUserProfileScreenBottomNavRoot(
            builder = this,
            navController = navController
        )

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

        helpsAddScreen(
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
        startDestination = HelpsDestinations.homeScreen.route,
        route = HelpsDestinations.homeBottomNavRoot.route
    ) {
        composable(
            route = HelpsDestinations.homeScreen.route,
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
        startDestination = HelpsDestinations.activeHelpsScreen.route,
        route = HelpsDestinations.activeHelpsBottomNavRoot.route
    ) {
        composable(HelpsDestinations.activeHelpsScreen.route) {
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
        startDestination = HelpsDestinations.pendingHelpsScreen.route,
        route = HelpsDestinations.pendingHelpsBottomNavRoot.route
    ) {
        composable(HelpsDestinations.pendingHelpsScreen.route) {
            HelpsPendingScreen(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
private fun helpsUserProfileScreenBottomNavRoot(
    builder: NavGraphBuilder,
    navController: NavHostController
) {
    builder.navigation(
        startDestination = HelpsDestinations.userProfileScreen.route,
        route = HelpsDestinations.userProfileBottomNavRoot.route
    ) {
        composable(HelpsDestinations.userProfileScreen.route) {
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
        route = HelpsDestinations.startScreen.route
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
        route = HelpsDestinations.guestScreen.route
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
        route = HelpsDestinations.createAccountScreen.route
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
        route = HelpsDestinations.addHelpsScreen.route
    ) {
        HelpsAddNewScreen(navController = navController)
    }
}