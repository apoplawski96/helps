package com.helps.presentation.helps.pending

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsScaffold

@Composable
fun HelpsPendingScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface) {
        HelpsScaffold(navController = navController) {
            HelpsPendingScreenContent()
        }
    }
}

@Composable
private fun HelpsPendingScreenContent() {
    Text(text = "Pending")
}