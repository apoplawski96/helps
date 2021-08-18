package com.helps.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.helps.presentation.common.composable.HelpsNavHost
import com.helps.presentation.common.theme.HelpsTheme
import com.helps.presentation.common.theme.HelpsThemeGreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            HelpsTheme {
                Surface(color = HelpsThemeGreen, modifier = Modifier.fillMaxSize()) {
                    HelpsNavHost()
                }
            }
        }
    }
}