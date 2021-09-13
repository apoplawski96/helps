package com.helps.data.auth.service

import com.helps.data.model.UserEntity
import kotlinx.coroutines.flow.Flow

interface AuthAPI {

    sealed class Result {

        data class Success(val user: UserEntity) : Result()

        data class Failure(val authErrorType: AuthErrorType, val message: String?) : Result()

        object PendingVerification : Result()

        object Logout : Result()

        companion object {

            fun success(user: UserEntity): Result = Success(user)

            fun pendingVerification(): Result = PendingVerification

            fun failure(authErrorType: AuthErrorType, message: String? = null): Result =
                Failure(authErrorType, message)

            fun logout(): Result = Logout
        }
    }

    enum class AuthErrorType {
        UNKNOWN
    }

    suspend fun createAccountWithEmailAndPassword(email: String, password: String): Flow<Result>

    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Result>

    suspend fun logout(): Flow<Result>
}