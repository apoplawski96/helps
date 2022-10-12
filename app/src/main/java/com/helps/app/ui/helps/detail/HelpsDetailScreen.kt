package com.helps.app.ui.helps.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helps.app.R
import com.helps.app.ui.PreviewData
import com.helps.app.ui.common.composable.HelpsDivider
import com.helps.app.ui.common.composable.HelpsScreenScaffold
import com.helps.app.ui.common.composable.HelpsText
import com.helps.app.ui.common.composable.TopBarMode
import com.helps.app.ui.common.theme.HelpsTheme
import com.helps.app.ui.helps.common.model.HelpsItemUI

@Composable
fun HelpsDetailScreen(
    helpsId: String?,
    viewModel: HelpsDetailViewModel,
) {
    if (helpsId == null) return

    LaunchedEffect(key1 = null) {
        viewModel.download(helpsId)
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        ImageBox(item.imageUrl)
        HelpsDivider(color = Color.Red)
        Header(item.title, item.datePublished)
        HelpsDivider(color = Color.Gray)
        Description(item.summary)
    }
}

@Composable
private fun ImageBox(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )
    }
}

@Composable
private fun Header(title: String, datePublished: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(HelpsTheme.colors.secondary)
            .padding(16.dp)
    ) {
        HelpsText(text = datePublished, color = Color.DarkGray, size = 12.sp)
        HelpsText(text = title, color = Color.Black, size = 22.sp)
    }
}

@Composable
private fun Description(description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(HelpsTheme.colors.secondary)
            .padding(16.dp)
    ) {
        HelpsText(text = "Description", color = Color.DarkGray, size = 12.sp)
        HelpsText(text = description, color = Color.Black)
    }
}

@Preview
@Composable
private fun HelpsDetailScreenPreview() {
    HelpsTheme(darkTheme = false) {
        HelpsDetailScreenContent(item = PreviewData.Helps.item)
    }
}
