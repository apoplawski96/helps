package com.helps.presentation.helps.active

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsScreenScaffold
import com.helps.presentation.common.theme.HelpsTheme
import com.helps.presentation.helps.HelpsList
import com.helps.presentation.helps.getMockItems

@Composable
fun HelpsActiveScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(navController) {
            HelpsActiveScreenContent()
        }
    }
}

@Composable
private fun HelpsActiveScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Your active Helps")
}