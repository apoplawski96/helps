package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.helps.presentation.common.theme.HelpsTheme

@Composable
fun HelpsButtonPrimary(label: String, onClick: () -> Unit) {
    HelpsButton(label = label, onClick = onClick, variant = HelpsButtonVariant.PRIMARY)
}

@Composable
fun HelpsButtonSecondary(label: String, onClick: () -> Unit) {
    HelpsButton(label = label, onClick = onClick, variant = HelpsButtonVariant.SECONDARY)
}

@Composable
private fun HelpsButton(label: String, onClick: () -> Unit, variant: HelpsButtonVariant) {
    val buttonColors: HelpsButtonColors = when (variant) {
        HelpsButtonVariant.PRIMARY -> HelpsButtonColors(
            background = HelpsTheme.colors.primary,
            content = HelpsTheme.colors.secondary
        )
        HelpsButtonVariant.SECONDARY -> HelpsButtonColors(
            background = HelpsTheme.colors.secondary,
            content = HelpsTheme.colors.primary
        )
    }

    Button(
        modifier = Modifier.height(50.dp).fillMaxWidth().padding(horizontal = 32.dp),
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColors.background,
            contentColor = buttonColors.content
        )
    ) {
        Text(text = label, fontWeight = FontWeight.Bold)
    }
}

private data class HelpsButtonColors(val background: Color, val content: Color)

private enum class HelpsButtonVariant {
    PRIMARY,
    SECONDARY;
}