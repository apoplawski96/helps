package com.helps.app.data.auth.service.register

import com.google.firebase.auth.FirebaseAuth
import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.domain.auth.model.AuthErrorType
import com.helps.app.domain.auth.model.HelpsUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseRegisterService @Inject constructor(
    private val firebaseAuthInstance: FirebaseAuth
) : RegisterAPI {

    @ExperimentalCoroutinesApi
    override suspend fun createAccountWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuthInstance.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { firebaseAuthResult ->
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