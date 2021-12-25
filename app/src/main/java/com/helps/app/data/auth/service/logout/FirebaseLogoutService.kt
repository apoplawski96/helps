package com.helps.app.data.auth.service.logout

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class FirebaseLogoutService @Inject constructor(
    private val firebaseAuthInstance: FirebaseAuth
) : LogoutAPI {

    override fun logout()  {
        firebaseAuthInstance.signOut()
    }
}