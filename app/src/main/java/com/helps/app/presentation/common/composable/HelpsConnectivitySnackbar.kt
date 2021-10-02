package com.helps.app.presentation.common.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SignalWifiOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.helps.app.presentation.common.theme.HelpsTheme
import com.helps.app.presentation.common.theme.HelpsThemeDarkGrey

@ExperimentalAnimationApi
@Composable
fun HelpsConnectivitySnackbar(isNetworkAvailable: Boolean) {
    AnimatedVisibility(visible = isNetworkAvailable.not()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            backgroundColor = Color.White
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Icon(
                    imageVector = Icons.Outlined.SignalWifiOff,
                    contentDescription = "",
                    tint = HelpsTheme.colors.accent,
                    modifier = Modifier.padding(vertical = 12.dp).padding(start = 12.dp)
                )
                HelpsText(
                    text = "No internet connection.",
                    color = HelpsThemeDarkGrey,
                    modifier = Modifier.padding(12.dp),
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}