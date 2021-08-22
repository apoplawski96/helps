package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun HelpsScaffold(
    navController: NavController,
    topBar: (@Composable () -> Unit)? = { HelpsTopBar(true) },
    bottomBar: (@Composable () -> Unit)? = { HelpsBottomNav(navController) },
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { topBar?.invoke() },
        bottomBar = { bottomBar?.invoke() },
        backgroundColor = Color.Transparent
    ) {
        content(it)
    }
}