package com.helps.app.domain.auth.validator

import com.helps.app.domain.auth.validator.model.InputValidator
import com.helps.app.domain.auth.validator.model.TextInputValidation

object EmailValidator : InputValidator {

    private const val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"

    override fun getInputValidation(input: String): TextInputValidation {
        return when (input.length) {
            0 -> TextInputValidation.Invalid.InputEmpty
            else -> {
                return if (EMAIL_REGEX.toRegex().matches(input)) {
                    TextInputValidation.Valid
                } else {
                    TextInputValidation.Invalid.EmailFormat
                }
            }
        }
    }
}