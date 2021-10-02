package com.helps.app.presentation.profile

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.app.presentation.common.composable.HelpsScreenScaffold
import com.helps.app.presentation.common.theme.HelpsTheme

@Composable
fun HelpsUserProfileScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(navController = navController) {
            HelpsUserProfileScreenContent()
        }
    }
}

@Composable
private fun HelpsUserProfileScreenContent() {
    Text(text = "User")
}