package com.helps.domain.auth.validator.model

interface InputValidator {

    fun getInputValidation(input: String): TextInputValidation
}