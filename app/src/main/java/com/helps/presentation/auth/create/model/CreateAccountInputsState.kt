package com.helps.presentation.auth.create.model

import com.helps.domain.auth.validator.model.TextInputValidation
import kotlinx.coroutines.flow.MutableStateFlow

data class CreateAccountInputsState(
    val username: MutableStateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
    val email: MutableStateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
    val password: MutableStateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
    val passwordConfirm: MutableStateFlow<TextInputValidation> = MutableStateFlow(TextInputValidation.None),
) {

    companion object { fun initial() = CreateAccountInputsState() }

    fun inputsValid(): Boolean =
        inputs().all { it.value is TextInputValidation.Valid }

    private fun inputs() = listOf(username, email, password, passwordConfirm)
}
