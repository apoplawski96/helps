package com.helps.domain.auth.validator

import com.helps.domain.auth.validator.model.InputValidator
import com.helps.domain.auth.validator.model.TextInputValidation

// TODO - wydzielic typy walidacji do poszczegolnych walidatorow
object PasswordValidator : InputValidator {

    override fun getInputValidation(input: String): TextInputValidation = when (input.length) {
        0 -> TextInputValidation.Invalid.InputEmpty
        in 1..5 -> TextInputValidation.Invalid.PasswordTooShort
        else -> TextInputValidation.Valid
    }
}