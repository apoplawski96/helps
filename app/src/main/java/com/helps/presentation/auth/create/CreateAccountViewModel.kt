package com.helps.presentation.auth.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.data.auth.service.AuthAPI
import com.helps.domain.auth.repository.UserRepository
import com.helps.domain.auth.validator.EmailValidator
import com.helps.domain.auth.validator.PasswordValidator
import com.helps.domain.auth.validator.UsernameValidator
import com.helps.domain.auth.validator.model.TextInputValidation
import com.helps.presentation.auth.create.model.CreateAccountInputsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val userRepository: UserRepository
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
    val viewState: MutableState<ViewState> = mutableStateOf(ViewState.Idle)

    fun createAccount(email: String, password: String, username: String) {

        if (inputsState.allInputsValid()) return

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

    fun setConfirmPassword(text: String) {
        _passwordConfirm.value = PasswordValidator.getInputValidation(text)
    }

    private fun handleAuthResult(authResult: AuthAPI.Result) {
        viewState.value = when (authResult) {
            is AuthAPI.Result.PendingVerification -> ViewState.RegistrationSuccess
            is AuthAPI.Result.Failure -> ViewState.RegistrationFailure(authResult.exception?.message)
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

//                navController.navigate(
//                    HelpsDestinations.MainSection.BottomNavSection.homeScreen.route
//                )