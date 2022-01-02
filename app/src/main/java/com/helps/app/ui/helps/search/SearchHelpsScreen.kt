package com.helps.app.ui.helps.search

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.helps.app.ui.common.composable.HelpsScreenScaffold
import com.helps.app.ui.common.composable.TopBarMode
import com.helps.app.ui.common.theme.HelpsTheme
import com.helps.app.ui.helps.common.component.HelpsList
import com.helps.app.ui.helps.common.model.HelpsItemUI

@Composable
fun SearchHelpsScreen(
    viewModel: SearchHelpsViewModel,
) {
    LaunchedEffect(key1 = null) {
        viewModel.downloadAll()
    }

    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(
            topBarMode = TopBarMode.WITH_BACK_NAVIGATION
        ) {
            HelpsSearchScreenContent(
                items = viewModel.helpsList.value,
                onItemClick = {
                    viewModel.navigateToHelpsDetail(it)
                }
            )
        }
    }
}

@Composable
private fun HelpsSearchScreenContent(
    onItemClick: (id: String) -> Unit,
    items: List<HelpsItemUI>
) {
    HelpsList(items = items, listHeaderText = "Want to help someone?", onItemClick = onItemClick)
}
