package com.helps.domain.auth.validator.model

sealed class TextInputValidation {

    object None : TextInputValidation()

    object Valid : TextInputValidation()

    sealed class Invalid(val message: String): TextInputValidation() {

        object InputEmpty : Invalid(message = "Field can't be empty.")

        object EmailFormat : Invalid(message = "Email is not formatted correctly.")

        object UsernameTooShort : Invalid(message = "Username should be minimum 3 characters.")

        object PasswordTooShort : Invalid(message = "Password has to be at least 6 characters.")
    }
}