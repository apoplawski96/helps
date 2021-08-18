package com.helps.presentation.common.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.helps.presentation.common.HelpsDestinations
import com.helps.presentation.guest.HelpsGuestScreen
import com.helps.presentation.start.HelpsStartScreen

@Composable
fun HelpsNavHost() {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }

    NavHost(
        navController = navController,
        startDestination = HelpsDestinations.startScreen.route
    ) {
        helpsStartScreen(
            builder = this,
            navController = navController
        )
        helpsGuestScreen(
            builder = this,
            navController = navController
        )
    }
}

private fun helpsStartScreen(
    builder: NavGraphBuilder,
    navController: NavController
) {
    builder.composable(
        route = HelpsDestinations.startScreen.route
    ) {
        HelpsStartScreen(navController = navController)
    }
}

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