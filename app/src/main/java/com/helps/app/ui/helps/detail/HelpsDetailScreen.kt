package com.helps.app.ui.helps.detail

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.helps.app.ui.common.composable.HelpsScreenScaffold
import com.helps.app.ui.common.composable.HelpsText
import com.helps.app.ui.common.composable.TopBarMode
import com.helps.app.ui.common.theme.HelpsTheme
import com.helps.app.ui.helps.common.model.HelpsItemUI

@Composable
fun HelpsDetailScreen(
    viewModel: HelpsDetailViewModel,
) {
    val id = ""

    LaunchedEffect(key1 = null) {
        viewModel.download(id)
    }

    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(
            topBarMode = TopBarMode.WITH_BACK_NAVIGATION
        ) {
            HelpsDetailScreenContent(
                item = viewModel.helpsItem.collectAsState(initial = HelpsItemUI()).value
            )
        }
    }
}

@Composable
private fun HelpsDetailScreenContent(
    item: HelpsItemUI
) {
    HelpsText(text = item.toString())
}
