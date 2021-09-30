package com.helps.presentation.auth.login.model

import com.helps.domain.auth.validator.model.TextInputValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class LoginInputsState(
    val email: StateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
    val password: StateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
) {

    fun allInputsValid(): Boolean = inputs().all { it.value is TextInputValidation.Valid }

    private fun inputs() = listOf(email, password)
}
