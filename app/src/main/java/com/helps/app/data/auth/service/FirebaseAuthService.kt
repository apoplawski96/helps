package com.helps.app.data.auth.service

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseAuthService @Inject constructor() : AuthAPI {

    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    @ExperimentalCoroutinesApi
    override suspend fun createAccountWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { firebaseAuthResult ->
                if (firebaseAuthResult.isSuccessful) {
                    trySend(
                        element = AuthAPI.Result.pendingVerification()
                    )
                    close()
                } else {
                    trySend(
                        element = AuthAPI.Result.failure(
                            errorType = AuthAPI.ErrorType.UNKNOWN,
                            exception = firebaseAuthResult.exception
                        )
                    )
                    close()
                }
            }
        awaitClose()
    }

    @ExperimentalCoroutinesApi
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuth.signInWithEmailAndPassword(password, email)
            .addOnCompleteListener { firebaseAuthResult: Task<AuthResult> ->
                if (firebaseAuthResult.isSuccessful) {
                    trySend(element = AuthAPI.Result.pendingVerification())
                    close()
                } else {
                    trySend(
                        element = AuthAPI.Result.failure(
                            errorType = AuthAPI.ErrorType.UNKNOWN,
                            exception = firebaseAuthResult.exception
                        )
                    )
                    close()
                }
            }
        awaitClose()
    }

    @ExperimentalCoroutinesApi
    override suspend fun logout(): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuth.signOut().also {
            trySend(AuthAPI.Result.logout())
            close()
        }
        awaitClose()
    }
}