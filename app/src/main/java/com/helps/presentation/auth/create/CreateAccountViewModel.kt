package com.helps.presentation.auth.create

import androidx.lifecycle.ViewModel
import com.helps.domain.auth.repository.UserRepository
import javax.inject.Inject

class CreateAccountViewModel @Inject constructor(
        private val userRepository: UserRepository
) : ViewModel() {
}