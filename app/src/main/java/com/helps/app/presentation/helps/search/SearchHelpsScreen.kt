package com.helps.app.presentation.helps.search

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.helps.app.presentation.common.composable.HelpsScreenScaffold
import com.helps.app.presentation.common.composable.TopBarMode
import com.helps.app.presentation.common.theme.HelpsTheme
import com.helps.app.presentation.helps.common.component.HelpsList
import com.helps.app.presentation.helps.common.model.HelpsItemUI

@Composable
fun SearchHelpsScreen(
    navController: NavController,
    viewModel: SearchHelpsViewModel,
) {
    LaunchedEffect(key1 = null) {
        viewModel.downloadAll()
    }

    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(
            navController = navController,
            topBarMode = TopBarMode.WITH_BACK_NAVIGATION
        ) {
            HelpsSearchScreenContent(
                items = viewModel.helpsList.value
            )
        }
    }
}

@Composable
private fun HelpsSearchScreenContent(
    items: List<HelpsItemUI>
) {
    HelpsList(items = items, listHeaderText = "Want to help someone?")
}
