package com.helps.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.view.WindowCompat
import com.helps.app.domain.app.network.ConnectivityLiveData
import com.helps.app.ui.auth.user.LocalUserState
import com.helps.app.ui.auth.user.UserStateViewModel
import com.helps.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var connectivityLiveData: ConnectivityLiveData

    @Inject
    lateinit var navigator: Navigator

    private val userStateViewModel: UserStateViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            CompositionLocalProvider(LocalUserState provides userStateViewModel) {
                HelpsApp(
                    navigator = navigator,
                    isNetworkAvailable = connectivityLiveData.observeAsState(initial = true).value
                )
            }
        }
    }
}