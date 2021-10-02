package com.helps.app.presentation.auth.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.domain.auth.repository.UserRepository
import com.helps.app.domain.auth.validator.ConfirmPasswordValidator
import com.helps.app.domain.auth.validator.EmailValidator
import com.helps.app.domain.auth.validator.PasswordValidator
import com.helps.app.domain.auth.validator.UsernameValidator
import com.helps.app.domain.auth.validator.model.TextInputValidation
import com.helps.app.presentation.HelpsDestinations
import com.helps.app.presentation.auth.create.model.CreateAccountInputsState
import com.helps.navigation.Navigator
import com.helps.navigation.model.NavigationDestination
import com.helps.navigation.model.navigationDestinationOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val navigator: Navigator
) : ViewModel() {

    private val _username: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)
    private val _email: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)
    private val _password: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)
    private val _passwordConfirm: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)

    val inputsState: CreateAccountInputsState = CreateAccountInputsState(
        username = _username,
        email = _email,
        password = _password,
        passwordConfirm = _passwordConfirm
    )

    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Idle)
    val viewState: State<ViewState> = _viewState

    fun createAccount(email: String, password: String, username: String) {
        if (inputsState.allInputsValid().not()) return

        _viewState.value = ViewState.Loading

        viewModelScope.launch {
            userRepository.createUserWithEmailAndPassword(email, password).let { authResultFlow ->
                authResultFlow.collect { result ->
                    handleAuthResult(result)
                }
            }
        }
    }

    fun setUsername(text: String) {
        _username.value = UsernameValidator.getInputValidation(text)
    }

    fun setEmail(text: String) {
        _email.value = EmailValidator.getInputValidation(text)
    }

    fun setPassword(text: String) {
        _password.value = PasswordValidator.getInputValidation(text)
    }

    fun setConfirmPassword(confirmPasswordText: String, passwordText: String) {
        _passwordConfirm.value =
            ConfirmPasswordValidator.getConfirmPasswordValidation(confirmPasswordText, passwordText)
    }

    fun navigate(navigationDestination: NavigationDestination) {
        navigator.navigate(navigationDestination)
    }

    fun navigateBack() {
        navigator.navigateBack()
    }

    private fun handleAuthResult(authResult: AuthAPI.Result) {
        _viewState.value = when (authResult) {
            is AuthAPI.Result.Success -> {
                navigator.navigate(
                    navigationDestinationOf(route = HelpsDestinations.MainSection.BottomNavSection.homeScreen.route)
                )
                ViewState.RegistrationSuccess
            }
            is AuthAPI.Result.Failure -> {
                ViewState.RegistrationFailure(authResult.exception?.message)
            }
            else -> ViewState.Idle
        }
    }

    sealed class ViewState() {
        object Idle : ViewState()
        object Loading : ViewState()
        object RegistrationSuccess : ViewState()
        data class RegistrationFailure(val errorMessage: String?) : ViewState()
    }
}