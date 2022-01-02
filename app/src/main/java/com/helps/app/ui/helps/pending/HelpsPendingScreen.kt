package com.helps.app.ui.helps.pending

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.app.ui.common.composable.HelpsScreenScaffold
import com.helps.app.ui.common.theme.HelpsTheme
import com.helps.app.ui.helps.common.component.HelpsList
import com.helps.app.ui.helps.common.component.getMockItems

@Composable
fun HelpsPendingScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold() {
            HelpsPendingScreenContent()
        }
    }
}

@Composable
private fun HelpsPendingScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Pending Helps", onItemClick = {})
}