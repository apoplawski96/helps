package com.helps.app.ui.start.welcome

import androidx.lifecycle.ViewModel
import com.helps.navigation.Navigator
import com.helps.navigation.model.NavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(private val navigator: Navigator) : ViewModel() {

    fun navigate(destination: NavigationDestination) {
        navigator.navigate(destination)
    }
}