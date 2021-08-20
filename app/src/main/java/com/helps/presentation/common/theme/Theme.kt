package com.helps.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val HelpsThemeGreen = Color(0xFF2FCC71)
private val HelpsThemeDarkGreen = Color(0xFF27C463)
private val HelpsThemeWhite = Color(0xFFFFFFFF)
private val HelpsThemeLightGrey = Color(0x9FFFFFFF)
private val HelpsThemeGrey = Color(0xFF757575)
private val HelpsThemeDarkGrey = Color(0xFF5c5c5c)
private val HelpsThemeRed = Color(0xFF921111)

private val LightColorPalette = lightColors(
    primary = HelpsThemeGreen,
    primaryVariant = HelpsThemeDarkGreen,
    secondary = HelpsThemeWhite,
    secondaryVariant = HelpsThemeLightGrey,
    background = HelpsThemeGrey,
    surface = HelpsThemeGreen,
    error = HelpsThemeRed,
    onPrimary = HelpsThemeWhite,
    onSecondary = HelpsThemeGreen,
    onSurface = HelpsThemeWhite
)

private val DarkColorPalette = darkColors(
    primary = HelpsThemeWhite,
    primaryVariant = HelpsThemeLightGrey,
    secondary = HelpsThemeGreen,
    secondaryVariant = HelpsThemeDarkGreen,
    background = HelpsThemeGrey,
    surface = HelpsThemeWhite,
    error = HelpsThemeRed,
    onPrimary = HelpsThemeWhite,
    onSecondary = HelpsThemeWhite,
    onSurface = HelpsThemeWhite
)

@Composable
fun HelpsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}