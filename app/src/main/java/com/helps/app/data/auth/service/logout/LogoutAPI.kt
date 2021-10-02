package com.helps.app.data.auth.service.logout

import com.helps.app.domain.auth.model.AuthAPI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

interface LogoutAPI {

    @ExperimentalCoroutinesApi
    suspend fun logout(): Flow<AuthAPI.Result>
}