package com.helps.presentation.auth.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.data.auth.service.AuthAPI
import com.helps.domain.auth.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val authState: MutableState<Boolean> = mutableStateOf(false)

    fun createAccount(email: String, password: String, username: String) {

        if (email.isEmpty() || password.isEmpty() || password.length < 6) return

        viewModelScope.launch {
            userRepository.createUserWithEmailAndPassword(email, password).let { authResultFlow ->
                authResultFlow.collect { result ->
                    authState.value = result is AuthAPI.Result.PendingVerification
                }
            }
        }
    }
}