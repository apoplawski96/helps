package com.helps.presentation.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsScaffold

@Composable
fun HelpsHomeScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface) {
        HelpsScaffold(navController = navController) {
            HelpsHomeScreenContent()
        }
    }
}

@Composable
private fun HelpsHomeScreenContent() {
    Text(text = "Home")
}