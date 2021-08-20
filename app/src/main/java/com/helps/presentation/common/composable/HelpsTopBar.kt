package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HelpsTopBar(statusBarHeight: Dp = 30.dp) {
    val actionBarHeight = 50.dp
    val topBarHeight = statusBarHeight + actionBarHeight

    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.height(topBarHeight)
    ) {
        Column {
            StatusBarPlaceholder(height = statusBarHeight)
            ActionBar(height = actionBarHeight)
        }
    }
}

@Composable
private fun StatusBarPlaceholder(height: Dp) {
    Spacer(modifier = Modifier
        .height(height)
        .fillMaxWidth())
}

@Composable
private fun ActionBar(height: Dp) {
    Box(modifier = Modifier
        .height(height)
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButton {}
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            HelpsLogo(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp))
        }
    }
}

@Composable
private fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Filled.ChevronLeft, contentDescription = "Back button", modifier = Modifier.fillMaxSize())
    }
}

@Preview
@Composable
private fun HelpsTopBarPreview() {
    HelpsTopBar(statusBarHeight = 24.dp)
}