package com.helps.app.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.app.domain.auth.model.HelpsUser
import com.helps.app.domain.auth.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _user = userRepository.user
    val user: StateFlow<HelpsUser?> = _user

    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
        }
    }
}