package com.helps.presentation.helps.active

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsScaffold

@Composable
fun HelpsActiveScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface) {
        HelpsScaffold(navController = navController) {
            HelpsActiveScreenContent()
        }
    }
}

@Composable
private fun HelpsActiveScreenContent() {
    Text(text = "Active")
}