package com.helps.app.domain.auth.repository

import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.domain.auth.model.HelpsUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface UserRepository {

    val user: StateFlow<HelpsUser?>

    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<AuthAPI.Result>

    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<AuthAPI.Result>

    // TODO: This is very dumb, refactor later so the user state is handled inside UserRepository
    suspend fun updateUserState(result: AuthAPI.Result)

    suspend fun logout()
}