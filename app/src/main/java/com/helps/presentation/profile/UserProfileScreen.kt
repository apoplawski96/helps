package com.helps.presentation.profile

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsScaffold
import com.helps.presentation.common.composable.HelpsTopBar

@Composable
fun HelpsUserProfileScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface) {
        HelpsScaffold(
            navController = navController,
            topBar = { HelpsTopBar(withBackNavigation = false) }
        ) {
            HelpsUserProfileScreenContent()
        }
    }
}

@Composable
private fun HelpsUserProfileScreenContent() {
    Text(text = "User")
}