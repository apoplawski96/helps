package com.helps.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.helps.presentation.common.composable.HelpsRootScaffold
import com.helps.presentation.common.theme.HelpsTheme

@ExperimentalAnimationApi
@Composable
fun HelpsApp() {
    HelpsTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            val navController = rememberAnimatedNavController()
            val systemUiController = rememberSystemUiController()

            HelpsRootScaffold(
                navController = navController,
            ) {
                HelpsNavHost(navController, systemUiController)
            }
        }
    }
}