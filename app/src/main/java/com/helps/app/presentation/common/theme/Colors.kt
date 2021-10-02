package com.helps.app.presentation.common.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Stable
class HelpsColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    secondaryVariant2: Color,
    textOnPrimary: Color,
    textOnSecondary: Color,
    textOnSecondaryButton: Color,
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
    var secondaryVariant2 by mutableStateOf(secondaryVariant2)
        private set
    var textOnPrimary by mutableStateOf(textOnPrimary)
        private set
    var textOnPrimaryButton by mutableStateOf(textOnSecondaryButton)
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

    fun update(other: HelpsColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        secondary = other.secondary
        secondaryVariant = other.secondaryVariant
        secondaryVariant2 = other.secondaryVariant2
        textOnPrimary = other.textOnPrimary
        textOnPrimaryButton = other.textOnPrimaryButton
        textOnSecondary = other.textOnSecondary
        accent = other.accent
        listItemBackground = other.listItemBackground
        archived = other.archived
        isDark = other.isDark
    }

    fun copy(): HelpsColors = HelpsColors(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = secondary,
        secondaryVariant = secondaryVariant,
        secondaryVariant2 = secondaryVariant2,
        textOnPrimary = textOnPrimary,
        textOnSecondaryButton = textOnPrimaryButton,
        textOnSecondary = textOnSecondary,
        accent = accent,
        listItemBackground = listItemBackground,
        archived = archived,
        isDark = isDark
    )
}

@Composable
fun ProvideHelpsColors(
    colors: HelpsColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalHelpsColors provides colorPalette, content = content)
}

val LocalHelpsColors = staticCompositionLocalOf<HelpsColors> {
    error("No HelpsColorPalette provided")
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Transparent
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)