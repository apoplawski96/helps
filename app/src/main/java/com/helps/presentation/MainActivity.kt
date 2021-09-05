package com.helps.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.view.WindowCompat
import androidx.lifecycle.LiveData
import com.helps.framework.ConnectivityLiveData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // TODO - Inject using Hilt
    private lateinit var connectivityLiveData: ConnectivityLiveData

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        connectivityLiveData = ConnectivityLiveData(this)

        setContent {
            HelpsApp(isNetworkAvailable = connectivityLiveData.observeAsState(initial = true).value)
        }
    }
}