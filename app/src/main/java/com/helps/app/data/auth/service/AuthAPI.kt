package com.helps.app.data.auth.service

import com.helps.app.data.model.UserEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

interface AuthAPI {

    sealed class Result {

        data class Success(val user: UserEntity) : Result()

        data class Failure(val errorType: ErrorType, val exception: Exception?
        ) : Result()

        object PendingVerification : Result()

        object Logout : Result()

        companion object {

            fun success(user: UserEntity): Result = Success(user)

            fun pendingVerification(): Result = PendingVerification

            fun failure(errorType: ErrorType, exception: Exception?): Result =
                Failure(errorType, exception)

            fun logout(): Result = Logout
        }
    }

    enum class ErrorType {
        UNKNOWN
    }

    @ExperimentalCoroutinesApi
    suspend fun createAccountWithEmailAndPassword(email: String, password: String): Flow<Result>

    @ExperimentalCoroutinesApi
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Result>

    @ExperimentalCoroutinesApi
    suspend fun logout(): Flow<Result>
}