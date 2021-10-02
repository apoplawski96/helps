package com.helps.app.data.auth.service.register

import com.helps.app.domain.auth.model.AuthAPI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

interface RegisterAPI {

    @ExperimentalCoroutinesApi
    suspend fun createAccountWithEmailAndPassword(email: String, password: String): Flow<AuthAPI.Result>
}