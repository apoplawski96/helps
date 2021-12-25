package com.helps.app.presentation.helps.pending

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.app.presentation.common.composable.HelpsScreenScaffold
import com.helps.app.presentation.common.theme.HelpsTheme
import com.helps.app.presentation.helps.common.component.HelpsList
import com.helps.app.presentation.helps.common.component.getMockItems

@Composable
fun HelpsPendingScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(navController = navController) {
            HelpsPendingScreenContent()
        }
    }
}

@Composable
private fun HelpsPendingScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Pending Helps")
}