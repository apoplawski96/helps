package com.helps.presentation.helps.pending

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsDestinationScaffold
import com.helps.presentation.common.theme.HelpsTheme
import com.helps.presentation.helps.HelpsList
import com.helps.presentation.helps.getMockItems

@Composable
fun HelpsPendingScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsDestinationScaffold() {
            HelpsPendingScreenContent()
        }
    }
}

@Composable
private fun HelpsPendingScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Pending Helps")
}