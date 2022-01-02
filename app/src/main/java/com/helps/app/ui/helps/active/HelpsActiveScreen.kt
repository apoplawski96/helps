package com.helps.app.ui.helps.active

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.app.ui.common.composable.HelpsScreenScaffold
import com.helps.app.ui.common.theme.HelpsTheme
import com.helps.app.ui.helps.common.component.HelpsList
import com.helps.app.ui.helps.common.component.getMockItems

@Composable
fun HelpsActiveScreen() {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold() {
            HelpsActiveScreenContent()
        }
    }
}

@Composable
private fun HelpsActiveScreenContent() {
    HelpsList(items = getMockItems(), listHeaderText = "Your active Helps")
}