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

    val viewState: MutableState<ViewState> = mutableStateOf(ViewState.Idle)

    private val _inputState = CreateAccountInputsState(
        username = MutableStateFlow(value = TextInputValidation.None),
        email = MutableStateFlow(value = TextInputValidation.None),
        password = MutableStateFlow(value = TextInputValidation.None),
        passwordConfirm = MutableStateFlow(value = TextInputValidation.None)
    )
    val inputsState: CreateAccountInputsState = _inputState

    fun createAccount(email: String, password: String, username: String) {

        if (_inputState.inputsValid().not()) return

        viewModelScope.launch {
            userRepository.createUserWithEmailAndPassword(email, password).let { authResultFlow ->
                authResultFlow.collect { result ->
                    handleAuthResult(result)
                }
            }
        }
    }

    fun setUsername(text: String) {
        _inputState.username.value = UsernameValidator.getInputValidation(text)
    }

    fun setEmail(text: String) {
        _inputState.email.value = EmailValidator.getInputValidation(text)
    }

    fun setPassword(text: String) {
        _inputState.password.value = PasswordValidator.getInputValidation(text)
    }

    fun setConfirmPassword(text: String) {
        _inputState.passwordConfirm.value = PasswordValidator.getInputValidation(text)
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