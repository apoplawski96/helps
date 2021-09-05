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
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import com.helps.presentation.common.theme.HelpsTheme

@Composable
fun HelpsTopBar(navController: NavController? = null) {
    TopAppBar(
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        modifier = Modifier.statusBarsPadding()
    ) {
        Column {
            ActionBar(
                withBackNavigation = navController != null,
                onBackNavigationClick = { navController?.popBackStack() }
            )
        }
    }
}

@Composable
private fun ActionBar(withBackNavigation: Boolean, onBackNavigationClick: () -> Unit) {
    Box(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        HelpsLogoOverlay()
        if (withBackNavigation) BackNavigationOverlay(onBackNavigationClick)
    }
}

@Composable
private fun BackNavigationOverlay(onBackNavigationClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        BackNavigationIcon { onBackNavigationClick() }
    }
}

@Composable
private fun HelpsLogoOverlay() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        HelpsLogo(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun BackNavigationIcon(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.ChevronLeft,
            contentDescription = "Back button",
            modifier = Modifier.fillMaxSize(),
            tint = HelpsTheme.colors.secondary
        )
    }
}

@Preview
@Composable
private fun HelpsTopBarPreview() {
    HelpsTopBar(null)
}