package com.helps.presentation.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsButtonWhite
import com.helps.presentation.common.composable.HelpsMottoText
import com.helps.presentation.common.composable.HelpsScaffold
import com.helps.presentation.common.theme.HelpsThemeGreen
import com.helps.presentation.common.theme.HelpsThemeWhite

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
            TextField(
                value = usernameText,
                onValueChange = { usernameText = it },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(HelpsThemeWhite))
            TextField(
                value = phoneNumberText,
                onValueChange = { phoneNumberText = it },
                label = { Text("Phone number") }
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(HelpsThemeWhite))
            Spacer(modifier = Modifier.height(64.dp))
            HelpsButtonWhite(label = "Get in") {
                
            }
        }
    }
}