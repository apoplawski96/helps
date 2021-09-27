package com.helps.presentation.auth.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.data.auth.service.AuthAPI
import com.helps.domain.auth.repository.UserRepository
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

    private val _username = MutableStateFlow("")
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _confirmPassword = MutableStateFlow("")

    fun createAccount(email: String, password: String, username: String) {

        if (email.isEmpty() || password.isEmpty() || password.length < 6) return

        viewModelScope.launch {
            userRepository.createUserWithEmailAndPassword(email, password).let { authResultFlow ->
                authResultFlow.collect { result ->
                    handleAuthResult(result)
                }
            }
        }
    }

    //                navController.navigate(
//                    HelpsDestinations.MainSection.BottomNavSection.homeScreen.route
//                )

    fun setUsername(text: String) {
        _username.value = text
    }

    fun setEmail(text: String) {
        _email.value = text
    }

    fun setPassword(text: String) {
        _password.value = text
    }

    fun setConfirmPassword(text: String) {
        _confirmPassword.value = text
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