package com.helps.presentation.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.helps.presentation.common.theme.HelpsTheme

@Composable
fun HelpsHorizontalSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HelpsDivider() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(HelpsTheme.colors.secondary)
    )
}