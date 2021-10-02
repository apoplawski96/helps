package com.helps.app.domain.auth.validator.model

interface InputValidator {

    fun getInputValidation(input: String): TextInputValidation
}