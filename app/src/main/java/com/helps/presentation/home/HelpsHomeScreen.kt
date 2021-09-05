package com.helps.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.presentation.HelpsDestinations
import com.helps.presentation.common.composable.HelpsScreenScaffold
import com.helps.presentation.common.composable.HelpsText
import com.helps.presentation.common.theme.HelpsTheme
import com.helps.presentation.common.theme.HelpsThemeGrey

@Composable
fun HelpsHomeScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(navController = navController) {
            HelpsHomeScreenContent(
                onAddHelpsClick = { navController.navigate(HelpsDestinations.MainSection.addHelpsScreen.route) },
                onSearchHelpsClick = { navController.navigate(HelpsDestinations.MainSection.searchHelpsScreen.route) }
            )
        }
    }
}

@Composable
private fun HelpsHomeScreenContent(
    onAddHelpsClick: () -> Unit,
    onSearchHelpsClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        HelpsCircleButton(Icons.Default.NotificationAdd, "Add Helps", onClick = onAddHelpsClick)
        HelpsCircleButton(Icons.Default.Groups, "Be a Hero!", onClick = onSearchHelpsClick)
    }
}

@Composable
private fun HelpsCircleButton(icon: ImageVector, label: String, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(32.dp)) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(HelpsTheme.colors.secondaryVariant2)
        )
        Box(
            modifier = Modifier
                .size(170.dp)
                .clip(CircleShape)
                .background(HelpsTheme.colors.secondary)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onClick, modifier = Modifier.size(90.dp)) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = HelpsTheme.colors.primary,
                    modifier = Modifier.size(90.dp)
                )
            }
            HelpsText(
                text = label,
                color = HelpsTheme.colors.primary,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Preview
@Composable
private fun HelpsHomeScreenPreview() {
    HelpsHomeScreenContent({}, {})
}