package com.helps.domain.auth.validator

import com.helps.domain.auth.validator.model.InputValidator
import com.helps.domain.auth.validator.model.TextInputValidation

object EmailValidator : InputValidator {

    override fun getInputValidation(input: String): TextInputValidation {
        return when (input.length) {
            0 -> TextInputValidation.Invalid.InputEmpty
            else -> {
                return if (input.contains("@")) {
                    TextInputValidation.Valid
                } else {
                    TextInputValidation.Invalid.EmailFormat
                }
            }
        }
    }
}