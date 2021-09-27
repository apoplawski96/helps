package com.helps.presentation.auth.common

import com.helps.domain.auth.validator.EmailValidator
import com.helps.domain.auth.validator.PasswordValidator
import com.helps.domain.auth.validator.UsernameValidator
import com.helps.domain.auth.validator.model.InputValidator
import com.helps.domain.auth.validator.model.TextInputValidation
import kotlinx.coroutines.flow.MutableStateFlow

data class AuthenticationInputField(
    val inputType: InputField,
    val inputText: MutableStateFlow<String>,

) {

}

enum class InputField(val validator: InputValidator) {
    EMAIL(validator = EmailValidator),
    USERNAME(validator = UsernameValidator),
    PASSWORD(validator = PasswordValidator);
}