package com.helps.domain.auth.repository

import com.helps.data.auth.service.AuthAPI
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<AuthAPI.Result>

    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<AuthAPI.Result>

    suspend fun logout(): Flow<AuthAPI.Result>
}