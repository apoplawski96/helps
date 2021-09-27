package com.helps.domain.auth.validator

import com.helps.domain.auth.validator.model.InputValidator
import com.helps.domain.auth.validator.model.TextInputValidation

object UsernameValidator : InputValidator {

    override fun getInputValidation(input: String): TextInputValidation = when (input.length) {
        0 -> TextInputValidation.Invalid.InputEmpty
        in 1..2 -> TextInputValidation.Invalid.UsernameTooShort
        else -> TextInputValidation.Valid
    }
}