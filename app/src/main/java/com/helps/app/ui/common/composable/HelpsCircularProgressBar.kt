package com.helps.app.ui.common.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun HelpsCircularProgressBar(
    isDisplayed: Boolean,
    color: Color
) {
    AnimatedVisibility(visible = isDisplayed) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            HelpsHorizontalSpacer(height = 16.dp)
            CircularProgressIndicator(color = color)
        }
    }
}