package com.helps.presentation.guest

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsButtonWhite
import com.helps.presentation.common.composable.HelpsMottoText
import com.helps.presentation.common.composable.HelpsScaffold
import com.helps.presentation.common.composable.HelpsTextField
import com.helps.presentation.common.theme.HelpsThemeGreen

@Composable
fun HelpsGuestScreen(navController: NavController) {
    HelpsScaffold(navController = navController, bottomBar = null) {
        HelpsGuestScreenContent()
    }
}

@Composable
private fun HelpsGuestScreenContent() {
    Surface(color = HelpsThemeGreen) {
        var usernameText by remember { mutableStateOf("") }
        var phoneNumberText by remember { mutableStateOf("") }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(128.dp))
            HelpsMottoText(text = "Use it as Guest")
            HelpsTextField(usernameText = usernameText, label = "Username") {
                usernameText = it
            }
            HelpsTextField(usernameText = phoneNumberText, label = "Phone number") {
                phoneNumberText = it
            }
            Spacer(modifier = Modifier.height(64.dp))
            HelpsButtonWhite(label = "Get in") {

            }
        }
    }
}