package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HelpsTopBar(withBackNavigation: Boolean) {
    TopAppBar(
        elevation = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        ActionBar(withBackNavigation)
    }
}

@Composable
private fun ActionBar(withBackNavigation: Boolean) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        HelpsLogoOverlay()
        if (withBackNavigation) BackNavigationOverlay()
    }
}

@Composable
private fun BackNavigationOverlay() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        BackNavigationIcon {}
    }
}

@Composable
private fun HelpsLogoOverlay() {
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

@Composable
private fun BackNavigationIcon(onClick: () -> Unit) {
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
    HelpsTopBar(true)
}