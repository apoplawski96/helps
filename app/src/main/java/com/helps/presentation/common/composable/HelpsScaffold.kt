package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun HelpsBottomNavScaffold(
    navController: NavController,
    bottomBar: (@Composable () -> Unit)? = { HelpsBottomNavigation(navController) },
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        bottomBar = { bottomBar?.invoke() },
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier.padding(it)) {
            content(it)
        }
    }
}

@Composable
fun HelpsScreenScaffold(
    navController: NavController? = null,
    topBarMode: TopBarMode = TopBarMode.NO_BACK_NAVIGATION,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { if (topBarMode != TopBarMode.NONE) HelpsTopBar(navController, topBarMode) },
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier.padding(it)) {
            content(it)
        }
    }
}