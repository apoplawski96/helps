package com.helps.app.presentation.helps.search

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.app.presentation.common.composable.HelpsScreenScaffold
import com.helps.app.presentation.common.composable.TopBarMode
import com.helps.app.presentation.common.theme.HelpsTheme
import com.helps.app.presentation.helps.HelpsList
import com.helps.app.presentation.helps.getMockItems

@Composable
fun HelpsSearchScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(navController = navController, topBarMode = TopBarMode.WITH_BACK_NAVIGATION) {
            HelpsSearchScreenContent()
        }
    }
}

@Composable
private fun HelpsSearchScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Want to help someone?")
}
