package com.helps.presentation.auth.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.data.auth.service.AuthAPI
import com.helps.domain.auth.repository.UserRepository
import com.helps.domain.auth.validator.EmailValidator
import com.helps.domain.auth.validator.PasswordValidator
import com.helps.domain.auth.validator.model.TextInputValidation
import com.helps.presentation.auth.create.CreateAccountViewModel
import com.helps.presentation.auth.login.model.LoginInputsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _email: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)
    private val _password: MutableStateFlow<TextInputValidation> =
        MutableStateFlow(value = TextInputValidation.None)

    val inputsState = LoginInputsState(
        email = _email,
        password = _password
    )

    val viewState: MutableState<ViewState> = mutableStateOf(ViewState.Idle)

    fun logIn(email: String, password: String) {
        if (inputsState.allInputsValid().not()) return

        viewState.value = ViewState.Loading

        viewModelScope.launch {
            userRepository.signInWithEmailAndPassword(email, password).let { authResultFlow ->
                authResultFlow.collect { result ->
                    handleAuthResult(result)
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
        viewState.value = when (authResult) {
            is AuthAPI.Result.PendingVerification -> {
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