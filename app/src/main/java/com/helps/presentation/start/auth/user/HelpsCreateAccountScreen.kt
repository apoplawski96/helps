package com.helps.presentation.start.auth.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.helps.presentation.common.composable.HelpsButtonSecondary
import com.helps.presentation.common.composable.HelpsMottoText
import com.helps.presentation.common.composable.HelpsRootScaffold
import com.helps.presentation.common.composable.HelpsTextField
import com.helps.presentation.common.theme.HelpsTheme

@Composable
fun HelpsCreateAccountScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsRootScaffold(navController = navController, bottomBar = null) {
            HelpsCreateAccountScreenContent()
        }
    }
}

@Composable
private fun HelpsCreateAccountScreenContent() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        var usernameText by remember { mutableStateOf("") }
        var emailText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }
        var confirmPasswordText by remember { mutableStateOf("") }

        HelpsMottoText(text = "Create an account")
        HelpsTextField(text = usernameText, label = "Username") {
            usernameText = it
        }
        HelpsTextField(text = emailText, label = "Email Address") {
            emailText = it
        }
        HelpsTextField(
            text = passwordText,
            label = "Password",
            visualTransformation = PasswordVisualTransformation()
        ) {
            passwordText = it
        }
        HelpsTextField(
            text = confirmPasswordText,
            label = "Confirm Password",
            visualTransformation = PasswordVisualTransformation()
        ) {
            confirmPasswordText = it
        }
        HelpsButtonSecondary(label = "Create an account") {

        }
    }
}
