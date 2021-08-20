package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.helps.presentation.HelpsBottomNavScreen

@Composable
fun HelpsScaffold(
    navController: NavController,
    bottomNavItems: List<HelpsBottomNavScreen> = listOf(),
    topBar: (@Composable () -> Unit)? = { HelpsTopBar(navController)},
    bottomBar: (@Composable () -> Unit)? = { HelpsBottomNav(navController, bottomNavItems) },
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { topBar?.invoke() },
        bottomBar = { bottomBar?.invoke() }
    ) {
        content(it)
    }
}