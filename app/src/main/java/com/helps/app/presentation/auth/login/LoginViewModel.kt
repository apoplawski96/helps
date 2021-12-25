package com.helps.app.presentation.auth.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.domain.auth.repository.UserRepository
import com.helps.app.domain.auth.validator.EmailValidator
import com.helps.app.domain.auth.validator.PasswordValidator
import com.helps.app.domain.auth.validator.model.TextInputValidation
import com.helps.app.presentation.HelpsDestinations
import com.helps.app.presentation.auth.login.model.LoginInputsState
import com.helps.navigation.Navigator
import com.helps.navigation.model.navigationDestinationOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val navigator: Navigator
) : ViewModel() {

    private val _email: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)
    private val _password: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)

    val inputsState = LoginInputsState(
        email = _email,
        password = _password
    )

    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Idle)
    val viewState: State<ViewState> = _viewState

    fun logIn(email: String, password: String) {
        if (inputsState.allInputsValid().not()) return

        _viewState.value = ViewState.Loading

        viewModelScope.launch {
            userRepository.signInWithEmailAndPassword(email, password).let { authResultFlow ->
                authResultFlow.collect { result ->
                    handleAuthResult(result)
                    userRepository.updateUserState(result)
                }
            }
        }
    }

    fun setEmail(text: String) {
        _email.value = EmailValidator.getInputValidation(text)
    }

    fun setPassword(text: String) {
        _password.value = PasswordValidator.getInputValidation(text)
    }

    private fun handleAuthResult(authResult: AuthAPI.Result) {
        _viewState.value = when (authResult) {
            is AuthAPI.Result.Success -> {
                navigator.navigate(
                    navigationDestinationOf(route = HelpsDestinations.MainSection.BottomNavSection.homeScreen.route)
                )
                ViewState.LoginSuccess
            }
            is AuthAPI.Result.Failure -> {
                ViewState.LoginFailure(authResult.exception?.message)
            }
            else -> ViewState.Idle
        }
    }

    sealed class ViewState() {
        object Idle : ViewState()
        object Loading : ViewState()
        object LoginSuccess : ViewState()
        data class LoginFailure(val errorMessage: String?) : ViewState()
    }
}