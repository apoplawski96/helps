package com.helps.presentation.auth.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.helps.presentation.HelpsDestinations
import com.helps.presentation.common.composable.*
import com.helps.presentation.common.theme.HelpsTheme

@Composable
fun HelpsCreateAccountScreen(
    navController: NavController,
    viewModel: CreateAccountViewModel
) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(
            navController = navController,
            topBarMode = TopBarMode.WITH_BACK_NAVIGATION
        ) {
            HelpsCreateAccountScreenContent(
                authState = viewModel.authState.value,
                onCreateAccountButtonClick = { email, password, username ->
//                navController.navigate(
//                    HelpsDestinations.MainSection.BottomNavSection.homeScreen.route
//                )
                    viewModel.createAccount(email, password, username)
                }
            )
        }
    }
}

@Composable
private fun HelpsCreateAccountScreenContent(
    authState: Boolean,
    onCreateAccountButtonClick: (email: String, password: String, username: String) -> Unit
) {
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
        HelpsTextField(
            text = usernameText,
            label = "Username",
            leadingIcon = Icons.Default.Person,
            onTextChanged = { usernameText = it }
        )
        HelpsTextField(
            text = emailText,
            label = "Email Address",
            leadingIcon = Icons.Default.Email,
            onTextChanged = { emailText = it }
        )
        HelpsTextField(
            text = passwordText,
            label = "Password",
            leadingIcon = Icons.Default.Password,
            onTextChanged = { passwordText = it }
        )
        HelpsTextField(
            text = confirmPasswordText,
            label = "Confirm Password",
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = Icons.Default.Password,
            onTextChanged = { confirmPasswordText = it }
        )
        HelpsButtonSecondary(
            label = "Create an account",
            onClick = {
                onCreateAccountButtonClick(
                    emailText,
                    passwordText,
                    usernameText
                )
            }
        )
        HelpsText(text = authState.toString())
    }
}
