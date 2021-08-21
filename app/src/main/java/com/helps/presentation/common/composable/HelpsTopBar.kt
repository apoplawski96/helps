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
fun HelpsTopBar() {
    TopAppBar(
        elevation = 0.dp,
    ) {
        ActionBar()
    }
}

@Composable
private fun ActionBar() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
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
            HelpsLogo(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )
        }
    }
}

@Composable
private fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.ChevronLeft,
            contentDescription = "Back button",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun HelpsTopBarPreview() {
    HelpsTopBar()
}