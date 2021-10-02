package com.helps.app.presentation.common.composable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.helps.app.R

@Composable
fun HelpsLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.helps_logo),
        contentDescription = "Helps logo",
        modifier = modifier
    )
}