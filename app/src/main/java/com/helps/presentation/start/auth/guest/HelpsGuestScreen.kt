package com.helps.presentation.start.auth.guest

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.presentation.HelpsDestinations
import com.helps.presentation.common.composable.HelpsButtonSecondary
import com.helps.presentation.common.composable.HelpsMottoText
import com.helps.presentation.common.composable.HelpsRootScaffold
import com.helps.presentation.common.composable.HelpsTextField
import com.helps.presentation.common.theme.HelpsTheme

@Composable
fun HelpsGuestScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsRootScaffold(navController = navController, bottomBar = null) {
            HelpsGuestScreenContent(
                onGetInButtonClicked = { navController.navigate(HelpsDestinations.BottomNavRoots.home.route) }
            )
        }
    }
}

@Composable
private fun HelpsGuestScreenContent(onGetInButtonClicked: () -> Unit) {
    var usernameText by remember { mutableStateOf("") }
    var phoneNumberText by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(128.dp))
        HelpsMottoText(text = "Use it as Guest")
        HelpsTextField(text = usernameText, label = "Username") { usernameText = it }
        HelpsTextField(text = phoneNumberText, label = "Phone number") { phoneNumberText = it }
        Spacer(modifier = Modifier.height(64.dp))
        HelpsButtonSecondary(label = "Get in", onClick = onGetInButtonClicked)
    }
}