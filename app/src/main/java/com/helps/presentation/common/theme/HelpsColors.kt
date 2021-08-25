package com.helps.presentation.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class HelpsColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    textOnPrimary: Color,
    textOnPrimaryButton: Color,
    textOnSecondary: Color,
    accent: Color,
    listItemBackground: Color,
    archived: Color,
    isDark: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set
    var textOnPrimary by mutableStateOf(textOnPrimary)
        private set
    var textOnPrimaryButton by mutableStateOf(textOnPrimaryButton)
        private set
    var textOnSecondary by mutableStateOf(textOnSecondary)
        private set
    var accent by mutableStateOf(accent)
        private set
    var listItemBackground by mutableStateOf(listItemBackground)
        private set
    var archived by mutableStateOf(archived)
        private set
    var isDark by mutableStateOf(isDark)
        private set
}