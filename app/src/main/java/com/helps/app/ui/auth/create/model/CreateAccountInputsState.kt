package com.helps.app.ui.auth.create.model

import com.helps.app.domain.auth.validator.model.TextInputValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class CreateAccountInputsState(
    val username: StateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
    val email: StateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
    val password: StateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
    val passwordConfirm: StateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
) {

    fun allInputsValid(): Boolean = inputs().all { it.value is TextInputValidation.Valid }

    private fun inputs() = listOf(username, email, password, passwordConfirm)
}
