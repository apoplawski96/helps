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
fun HelpsRootScaffold(
    navController: NavController,
    bottomBar: (@Composable () -> Unit)? = { HelpsBottomNav(navController) },
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
fun HelpsDestinationScaffold(
    topBar: (@Composable () -> Unit)? = { HelpsTopBar(null) },
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { topBar?.invoke() },
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier.padding(it)) {
            content(it)
        }
    }
}