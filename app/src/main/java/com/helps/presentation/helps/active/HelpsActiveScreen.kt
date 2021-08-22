package com.helps.presentation.helps.active

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsScaffold
import com.helps.presentation.common.composable.HelpsTopBar
import com.helps.presentation.helps.HelpsList
import com.helps.presentation.helps.getMockItems

@Composable
fun HelpsActiveScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary) {
        HelpsScaffold(
            navController = navController,
            topBar = { HelpsTopBar(withBackNavigation = false) }
        ) {
            HelpsActiveScreenContent()
        }
    }
}

@Composable
private fun HelpsActiveScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Your active Helps")
}