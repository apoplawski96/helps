package com.helps.app.domain.auth.model

interface AuthAPI {

    sealed class Result {

        data class Success(val user: HelpsUser) : Result()

        data class Failure(val errorType: AuthErrorType, val exception: Exception?) : Result()

        object Logout : Result()

        companion object {

            fun success(user: HelpsUser): Result = Success(user)

            fun failure(errorType: AuthErrorType, exception: Exception?): Result =
                Failure(errorType, exception)

            fun logout(): Result = Logout
        }
    }
}