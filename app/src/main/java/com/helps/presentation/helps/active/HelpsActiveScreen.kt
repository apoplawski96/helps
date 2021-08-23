package com.helps.presentation.helps.active

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsDestinationScaffold
import com.helps.presentation.helps.HelpsList
import com.helps.presentation.helps.getMockItems

@Composable
fun HelpsActiveScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary) {
        HelpsDestinationScaffold() {
            HelpsActiveScreenContent()
        }
    }
}

@Composable
private fun HelpsActiveScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Your active Helps")
}