package com.helps.app.data.auth.service.logout

import com.google.firebase.auth.FirebaseAuth
import com.helps.app.domain.auth.model.AuthAPI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseLogoutService @Inject constructor(
    private val firebaseAuthInstance: FirebaseAuth
) : LogoutAPI {

    @ExperimentalCoroutinesApi
    override suspend fun logout(): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuthInstance.signOut().also {
            trySend(AuthAPI.Result.logout())
            close()
        }
        awaitClose()
    }
}