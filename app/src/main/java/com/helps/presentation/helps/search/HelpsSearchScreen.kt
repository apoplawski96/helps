package com.helps.presentation.helps.search

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsScreenScaffold
import com.helps.presentation.common.theme.HelpsTheme
import com.helps.presentation.helps.HelpsList
import com.helps.presentation.helps.getMockItems

@Composable
fun HelpsSearchScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold() {
            HelpsSearchScreenContent()
        }
    }
}

@Composable
private fun HelpsSearchScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Want to help someone?")
}
