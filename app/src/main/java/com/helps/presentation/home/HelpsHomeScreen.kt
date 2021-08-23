package com.helps.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Doorbell
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.presentation.HelpsDestinations
import com.helps.presentation.common.composable.HelpsScaffold
import com.helps.presentation.common.composable.HelpsText
import com.helps.presentation.common.composable.HelpsTopBar

@Composable
fun HelpsHomeScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface) {
        HelpsScaffold(
            navController = navController,
            topBar = { HelpsTopBar(navController = null) }
        ) {
            HelpsHomeScreenContent(
                onAddHelpsClick = { navController.navigate(HelpsDestinations.addHelpsScreen.route) }
            )
        }
    }
}

@Composable
private fun HelpsHomeScreenContent(
    onAddHelpsClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        HelpsCircleButton(Icons.Default.Doorbell, "Add Helps", onClick = onAddHelpsClick)
        HelpsCircleButton(Icons.Default.Chat, "Be a Hero!", onClick = { })
    }
}

@Composable
private fun HelpsCircleButton(icon: ImageVector, label: String, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(32.dp)) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.secondaryVariant)
        )
        Box(
            modifier = Modifier
                .size(170.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.secondary)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.size(100.dp)
                )
            }
            HelpsText(text = label, color = MaterialTheme.colors.onSecondary)
        }
    }
}

@Preview
@Composable
private fun HelpsHomeScreenPreview() {
    HelpsHomeScreenContent({})
}