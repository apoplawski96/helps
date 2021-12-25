package com.helps.app.data.auth.service.login

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.domain.auth.model.AuthErrorType
import com.helps.app.domain.auth.model.HelpsUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseLoginService @Inject constructor(
    private val firebaseAuthInstance: FirebaseAuth
) : LoginAPI {

    @ExperimentalCoroutinesApi
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuthInstance.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { firebaseAuthResult: Task<AuthResult> ->
                if (firebaseAuthResult.isSuccessful) {
                    trySend(
                        element = AuthAPI.Result.success(
                            HelpsUser(
                                uuid = firebaseAuthResult.result?.user?.uid.orEmpty(),
                                name = firebaseAuthResult.result?.user?.displayName.orEmpty()
                            )
                        )
                    )
                    close()
                } else {
                    trySend(
                        element = AuthAPI.Result.failure(
                            errorType = AuthErrorType.UNKNOWN,
                            exception = firebaseAuthResult.exception
                        )
                    )
                    close()
                }
            }
        awaitClose()
    }
}