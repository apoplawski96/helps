package com.helps.presentation.auth.create

import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.domain.auth.validator.EmailValidator
import com.helps.domain.auth.validator.PasswordValidator
import com.helps.domain.auth.validator.UsernameValidator
import com.helps.presentation.common.composable.*
import com.helps.presentation.common.theme.HelpsTheme

@ExperimentalAnimationApi
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
                onPasswordTextChange = { viewModel.setPassword(it) },
                onPasswordConfirmTextChange = { viewModel.setConfirmPassword(it) },
                onEmailTextChange = { viewModel.setEmail(it) },
                onUsernameTextChange = { viewModel.setUsername(it) },
                onCreateAccountButtonClick = { email, password, username ->
                    viewModel.createAccount(email, password, username)
                }
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun HelpsCreateAccountScreenContent(
    onUsernameTextChange: (String) -> Unit,
    onEmailTextChange: (String) -> Unit,
    onPasswordTextChange: (String) -> Unit,
    onPasswordConfirmTextChange: (String) -> Unit,
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
        HelpsHorizontalSpacer(height = 8.dp)
        HelpsTextFieldWithValidation(
            text = usernameText,
            label = "Username",
            leadingIcon = Icons.Default.Person,
            validator = UsernameValidator,
            onTextChanged = {
                usernameText = it
                onUsernameTextChange(it)
            }
        )
        HelpsTextFieldWithValidation(
            text = emailText,
            label = "Email Address",
            leadingIcon = Icons.Default.Email,
            validator = EmailValidator,
            onTextChanged = {
                emailText = it
                onEmailTextChange(it)
            }
        )
        HelpsTextFieldWithValidation(
            text = passwordText,
            label = "Password",
            leadingIcon = Icons.Default.Password,
            validator = PasswordValidator,
            onTextChanged = {
                passwordText = it
                onPasswordTextChange(it)
            }
        )
        HelpsTextFieldWithValidation(
            text = confirmPasswordText,
            label = "Confirm Password",
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = Icons.Default.Password,
            validator = PasswordValidator,
            onTextChanged = {
                confirmPasswordText = it
                onPasswordConfirmTextChange(it)
            }
        )
        HelpsHorizontalSpacer(height = 16.dp)
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
    }
}
