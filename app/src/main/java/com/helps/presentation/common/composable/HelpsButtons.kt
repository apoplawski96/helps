package com.helps.presentation.common.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.helps.presentation.common.theme.HelpsThemeGreen
import com.helps.presentation.common.theme.HelpsThemeWhite

@Composable
fun HelpsButtonGreen(label: String, onClick: () -> Unit) {
    HelpsButton(label = label, onClick = onClick, variant = HelpsButtonVariant.GREEN)
}

@Composable
fun HelpsButtonWhite(label: String, onClick: () -> Unit) {
    HelpsButton(label = label, onClick = onClick, variant = HelpsButtonVariant.WHITE)
}

@Composable
private fun HelpsButton(label: String, onClick: () -> Unit, variant: HelpsButtonVariant) {
    val buttonColors: HelpsButtonColors = when (variant) {
        HelpsButtonVariant.GREEN -> HelpsButtonColors(HelpsThemeGreen, HelpsThemeWhite)
        HelpsButtonVariant.WHITE -> HelpsButtonColors(HelpsThemeWhite, HelpsThemeGreen)
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
    GREEN,
    WHITE;
}