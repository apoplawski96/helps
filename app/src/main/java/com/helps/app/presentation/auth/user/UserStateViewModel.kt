package com.helps.app.presentation.auth.user

import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import com.helps.app.domain.auth.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserStateViewModel @Inject constructor(
    userRepository: UserRepository
) : ViewModel() {

//    val state: StateFlow<Boolean> = userRepository.user.map { user ->
//        user != null
//    }.stateIn(
//        scope = this.viewModelScope,
//    )

    val user = userRepository.user
}

val LocalUserState = compositionLocalOf<UserStateViewModel> { error("User State Context Not Found!") }