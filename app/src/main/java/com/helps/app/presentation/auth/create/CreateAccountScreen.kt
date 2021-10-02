package com.helps.app.presentation.auth.create

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
import com.helps.app.presentation.HelpsDestinations
import com.helps.app.presentation.auth.create.model.CreateAccountInputsState
import com.helps.app.presentation.common.composable.*
import com.helps.app.presentation.common.theme.HelpsTheme
import com.helps.navigation.model.navigationDestinationOf

@ExperimentalAnimationApi
@Composable
fun HelpsCreateAccountScreen(
    viewModel: CreateAccountViewModel
) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(
            topBarMode = TopBarMode.WITH_BACK_NAVIGATION,
            onNavigateBackClick = { viewModel.navigateBack() }
        ) {
            HelpsCreateAccountScreenContent(
                viewState = viewModel.viewState.value,
                inputsState = viewModel.inputsState,
                onPasswordTextChange = { viewModel.setPassword(it) },
                onPasswordConfirmTextChange = { confirmPassword, password -> viewModel.setConfirmPassword(confirmPassword, password) },
                onEmailTextChange = { viewModel.setEmail(it) },
                onUsernameTextChange = { viewModel.setUsername(it) },
                onGoToLoginButtonClick = { viewModel.navigate(navigationDestinationOf(HelpsDestinations.StartSection.loginScreen.route)) },
                onCreateAccountButtonClick = { email, password, username ->
                    viewModel.createAccount(email, password, username)
                },
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun HelpsCreateAccountScreenContent(
    viewState: CreateAccountViewModel.ViewState,
    inputsState: CreateAccountInputsState,
    onUsernameTextChange: (String) -> Unit,
    onEmailTextChange: (String) -> Unit,
    onPasswordTextChange: (String) -> Unit,
    onPasswordConfirmTextChange: (confirmPassword: String, password: String) -> Unit,
    onGoToLoginButtonClick: () -> Unit,
    onCreateAccountButtonClick: (email: String, password: String, username: String) -> Unit,
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

        if (viewState is CreateAccountViewModel.ViewState.RegistrationFailure) {
            HelpsText(text = viewState.errorMessage.toString())
        }

        HelpsCircularProgressBar(
            isDisplayed = viewState is CreateAccountViewModel.ViewState.Loading,
            color = HelpsTheme.colors.secondary
        )
        HelpsMottoText(text = "Create an account")
        HelpsHorizontalSpacer(height = 8.dp)
        HelpsTextFieldWithValidation(
            text = usernameText,
            label = "Username",
            leadingIcon = Icons.Default.Person,
            inputValidation = inputsState.username.value,
            onTextChanged = {
                usernameText = it
                onUsernameTextChange(it)
            }
        )
        HelpsTextFieldWithValidation(
            text = emailText,
            label = "Email Address",
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
                onPasswordConfirmTextChange(confirmPasswordText, passwordText)
            }
        )
        HelpsTextFieldWithValidation(
            text = confirmPasswordText,
            label = "Confirm Password",
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = Icons.Default.Password,
            inputValidation = inputsState.passwordConfirm.value,
            onTextChanged = {
                confirmPasswordText = it
                onPasswordConfirmTextChange(it, passwordText)
                onPasswordTextChange(passwordText)
            }
        )
        HelpsHorizontalSpacer(height = 16.dp)
        HelpsButton(
            label = "Create an account",
            variant = if (inputsState.allInputsValid()) HelpsButtonVariant.SECONDARY else HelpsButtonVariant.DISABLED,
            onClick = {
                onCreateAccountButtonClick(
                    emailText,
                    passwordText,
                    usernameText
                )
            }
        )
        HelpsTextButton(label = "Already have an account? Log in", onClick = onGoToLoginButtonClick)
    }
}
