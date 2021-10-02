package com.helps.app.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.helps.app.presentation.common.composable.HelpsBottomNavScaffold
import com.helps.app.presentation.common.composable.HelpsConnectivitySnackbar
import com.helps.app.presentation.common.theme.HelpsTheme
import com.helps.navigation.Navigator

@ExperimentalAnimationApi
@Composable
fun HelpsApp(navigator: Navigator, isNetworkAvailable: Boolean) {
    HelpsTheme(darkTheme = false) {
        ProvideWindowInsets {
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxSize()
            ) {
                val navController = rememberAnimatedNavController()

                HelpsBottomNavScaffold(
                    navController = navController,
                    navigator = navigator
                ) {
                    Column() {
                        HelpsConnectivitySnackbar(isNetworkAvailable = isNetworkAvailable)
                        HelpsNavHost(navController = navController, navigator = navigator)
                    }
                }
            }
        }
    }
}