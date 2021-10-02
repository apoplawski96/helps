package com.helps.app.domain.auth.validator

import com.helps.app.domain.auth.validator.model.TextInputValidation

object ConfirmPasswordValidator {

    fun getConfirmPasswordValidation(confirmPassword: String, password: String): TextInputValidation {
        return when (confirmPassword.length) {
            0 -> TextInputValidation.Invalid.InputEmpty
            else -> {
                return if (confirmPassword == password) {
                    TextInputValidation.Valid
                } else {
                    TextInputValidation.Invalid.PasswordsMustMatch
                }
            }
        }
    }
}