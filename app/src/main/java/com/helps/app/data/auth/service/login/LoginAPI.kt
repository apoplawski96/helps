package com.helps.app.data.auth.service.login

import com.helps.app.domain.auth.model.AuthAPI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

interface LoginAPI {

    @ExperimentalCoroutinesApi
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<AuthAPI.Result>
}