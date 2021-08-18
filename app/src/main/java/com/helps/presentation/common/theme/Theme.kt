package com.helps.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = HelpsThemeGreen,
    primaryVariant = HelpsThemeDarkGreen,
    secondary = HelpsThemeWhite
)

private val LightColorPalette = lightColors(
    primary = HelpsThemeGreen,
    primaryVariant = HelpsThemeDarkGreen,
    secondary = HelpsThemeWhite
)

@Composable
fun HelpsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}