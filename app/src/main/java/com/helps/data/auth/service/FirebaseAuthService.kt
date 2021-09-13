package com.helps.data.auth.service

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.helps.data.model.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseAuthService @Inject constructor() : AuthAPI {

    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    override suspend fun createAccountWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuth.createUserWithEmailAndPassword(password, email)
            .addOnCompleteListener { authResultTask: Task<AuthResult> ->
                if (authResultTask.isSuccessful) {
                    trySend(AuthAPI.Result.pendingVerification())
                } else {
                    trySend(AuthAPI.Result.failure(authErrorType = AuthAPI.AuthErrorType.UNKNOWN))
                }
            }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuth.signInWithEmailAndPassword(password, email)
            .addOnCompleteListener { authResultTask: Task<AuthResult> ->
                if (authResultTask.isSuccessful) {
                    trySend(AuthAPI.Result.success(user = UserEntity()))
                } else {
                    trySend(AuthAPI.Result.failure(authErrorType = AuthAPI.AuthErrorType.UNKNOWN))
                }
            }
    }

    override suspend fun logout(): Flow<AuthAPI.Result> = callbackFlow {
        firebaseAuth.signOut().also {
            trySend(AuthAPI.Result.logout())
        }
    }
}