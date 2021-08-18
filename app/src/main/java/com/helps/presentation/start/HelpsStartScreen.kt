package com.helps.presentation.start

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.helps.presentation.common.HelpsDestinations
import com.helps.presentation.common.composable.HelpsButtonWhite
import com.helps.presentation.common.composable.HelpsLogo
import com.helps.presentation.common.composable.HelpsMottoText

@Composable
fun HelpsStartScreen(
    navController: NavController
) {
    HelpsStartScreenContent(
        navigateToUserScreen = {},
        navigateToGuestScreen = { navController.navigate(route = HelpsDestinations.guestScreen.route) }
    )
}

@Composable
private fun HelpsStartScreenContent(
    navigateToUserScreen: () -> Unit = {},
    navigateToGuestScreen: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        HelpsLogo(modifier = Modifier.height(164.dp))
        Spacer(modifier = Modifier.height(64.dp))
        HelpsMottoText(
            text = "Things get solved \n" +
                    "if you get involved"
        )
        Spacer(modifier = Modifier.height(64.dp))
        HelpsButtonWhite(label = "User") { navigateToUserScreen() }
        Spacer(modifier = Modifier.height(16.dp))
        HelpsButtonWhite(label = "Guest") { navigateToGuestScreen() }
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Preview
@Composable
private fun HelpsStartScreenContentPreview() {
    Surface(color = MaterialTheme.colors.background) {
        HelpsStartScreenContent()
    }
}
