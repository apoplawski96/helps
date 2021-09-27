package com.helps.presentation.common.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helps.domain.auth.validator.model.InputValidator
import com.helps.domain.auth.validator.model.TextInputValidation
import com.helps.presentation.common.theme.HelpsTheme

@ExperimentalAnimationApi
@Composable
fun HelpsTextFieldWithValidation(
    text: String,
    label: String,
    leadingIcon: ImageVector,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    validator: InputValidator,
    onTextChanged: (String) -> Unit,
    onValidationStateChanged: (TextInputValidation) -> Unit = {}
) {
    var inputValidationState: TextInputValidation by remember { mutableStateOf(value = TextInputValidation.None) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HelpsHorizontalSpacer(height = 16.dp)
        HelpsTextField(
            text = text,
            label = label,
            leadingIcon = leadingIcon,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            indicatorColor = if (inputValidationState is TextInputValidation.Invalid) {
                HelpsTheme.colors.accent
            } else {
                HelpsTheme.colors.secondary
            },
            onTextChanged = {
                onTextChanged(it)
                inputValidationState = validator.getInputValidation(it)
                onValidationStateChanged(inputValidationState)
            }
        )
        HelpsValidationText(inputValidationState = inputValidationState)
        HelpsHorizontalSpacer(height = 16.dp)
        HelpsDivider()
        HelpsHorizontalSpacer(height = 16.dp)
    }
}

@ExperimentalAnimationApi
@Composable
private fun HelpsValidationText(inputValidationState: TextInputValidation) {
    AnimatedVisibility(
        visible = inputValidationState is TextInputValidation.Invalid
    ) {
        if (inputValidationState is TextInputValidation.Invalid) {
            HelpsText(
                text = inputValidationState.message,
                color = HelpsTheme.colors.accent,
                size = 10.sp
            )
        }
    }
}