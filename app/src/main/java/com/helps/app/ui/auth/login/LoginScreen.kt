package com.helps.app.ui.auth.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.app.ui.auth.login.model.LoginInputsState
import com.helps.app.ui.common.composable.*
import com.helps.app.ui.common.theme.HelpsTheme

@ExperimentalAnimationApi
@Composable
fun HelpsLoginScreen(
    viewModel: LoginViewModel
) {
    HelpsScreenScaffold(
        topBarMode = TopBarMode.WITH_BACK_NAVIGATION
    ) {
        HelpsLoginScreenContent(
            onLogInClick = { email, password ->
                viewModel.logIn(email, password)
            },
            inputsState = viewModel.inputsState,
            onEmailTextChange = { viewModel.setEmail(it) },
            onPasswordTextChange = { viewModel.setPassword(it) },
            viewState = viewModel.viewState.value
        )
    }
}

@ExperimentalAnimationApi
@Composable
private fun HelpsLoginScreenContent(
    viewState: LoginViewModel.ViewState,
    onLogInClick: (email: String, password: String) -> Unit,
    inputsState: LoginInputsState,
    onEmailTextChange: (String) -> Unit,
    onPasswordTextChange: (String) -> Unit,
) {
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    if (viewState is LoginViewModel.ViewState.LoginFailure) {
        HelpsText(text = viewState.errorMessage.toString())
    }

    HelpsCircularProgressBar(
        isDisplayed = viewState is LoginViewModel.ViewState.Loading,
        color = HelpsTheme.colors.secondary
    )

    Surface(color = HelpsTheme.colors.primary) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            HelpsHorizontalSpacer(height = 64.dp)
            HelpsLogo()
            HelpsHorizontalSpacer(height = 64.dp)
            HelpsTextFieldWithValidation(
                text = emailText,
                label = "Email",
                leadingIcon = Icons.Default.Email,
                inputValidation = inputsState.email.value,
                onTextChanged = {
                    emailText = it
                    onEmailTextChange(it)
                }
            )
            HelpsTextFieldWithValidation(
                text = passwordText,
                label = "Password",
                leadingIcon = Icons.Default.Password,
                inputValidation = inputsState.password.value,
                onTextChanged = {
                    passwordText = it
                    onPasswordTextChange(it)
                }
            )
            HelpsButtonSecondary(label = "Log in", onClick = { onLogInClick(emailText, passwordText) })
        }
    }
}