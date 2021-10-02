package com.helps.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.view.WindowCompat
import com.helps.app.domain.app.ConnectivityLiveData
import com.helps.navigation.HelpsNavigator
import com.helps.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var connectivityLiveData: ConnectivityLiveData

    @Inject
    lateinit var navigator: Navigator

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            HelpsApp(
                navigator = navigator,
                isNetworkAvailable = connectivityLiveData.observeAsState(initial = true).value
            )
        }
    }
}