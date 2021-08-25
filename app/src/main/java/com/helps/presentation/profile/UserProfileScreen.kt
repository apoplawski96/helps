package com.helps.presentation.profile

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsDestinationScaffold

@Composable
fun HelpsUserProfileScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface) {
        HelpsDestinationScaffold() {
            HelpsUserProfileScreenContent()
        }
    }
}

@Composable
private fun HelpsUserProfileScreenContent() {
    Text(text = "User")
}