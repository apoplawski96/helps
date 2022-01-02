package com.helps.app.ui.common.composable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.helps.app.ui.common.theme.HelpsTheme
import com.helps.navigation.Navigator

@ExperimentalAnimationApi
@Composable
fun HelpsBottomNavScaffold(
    navController: NavController,
    navigator: Navigator,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        bottomBar = { HelpsBottomNavigation(navController, navigator) },
        backgroundColor = Color.Transparent
    ) {
        Surface(color = HelpsTheme.colors.primary) {
            Box(modifier = Modifier
                .padding(it)
                .background(Color.Transparent)) {
                content(it)
            }
        }
    }
}

@Composable
fun HelpsScreenScaffold(
    topBarMode: TopBarMode = TopBarMode.NO_BACK_NAVIGATION,
    onNavigateBackClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { if (topBarMode != TopBarMode.NONE) HelpsTopBar(topBarMode, onNavigateBackClick) },
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier
            .padding(it)
            .background(Color.Transparent)) {
            content(it)
        }
    }
}