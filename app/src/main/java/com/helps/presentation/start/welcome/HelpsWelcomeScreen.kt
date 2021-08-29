package com.helps.presentation.start.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.presentation.HelpsDestinations
import com.helps.presentation.common.composable.HelpsButtonSecondary
import com.helps.presentation.common.composable.HelpsLogo
import com.helps.presentation.common.composable.HelpsMottoText
import com.helps.presentation.common.theme.HelpsTheme

@Composable
fun HelpsWelcomeScreen(
    navController: NavController
) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsWelcomeScreenContent(
            navigateToUserScreen = { navController.navigate(route = HelpsDestinations.StartSection.createAccountScreen.route) },
            navigateToGuestScreen = { navController.navigate(route = HelpsDestinations.StartSection.guestScreen.route) }
        )
    }
}

@Composable
private fun HelpsWelcomeScreenContent(
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
        HelpsButtonSecondary(label = "User") { navigateToUserScreen() }
        Spacer(modifier = Modifier.height(16.dp))
        HelpsButtonSecondary(label = "Guest") { navigateToGuestScreen() }
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Preview
@Composable
private fun HelpsWelcomeScreenContentPreview() {
    HelpsWelcomeScreenContent()
}
