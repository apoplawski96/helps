package com.helps.app.domain.auth.repository

import com.helps.app.data.auth.service.AuthAPI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FirebaseUserRepository @Inject constructor(
        private val firebaseAuthAPI: AuthAPI
) : UserRepository {

    override suspend fun createUserWithEmailAndPassword(
            email: String,
            password: String
    ): Flow<AuthAPI.Result> = firebaseAuthAPI.createAccountWithEmailAndPassword(email, password)

    override suspend fun signInWithEmailAndPassword(
            email: String,
            password: String
    ): Flow<AuthAPI.Result> = firebaseAuthAPI.signInWithEmailAndPassword(email, password)

    override suspend fun logout(): Flow<AuthAPI.Result> = firebaseAuthAPI.logout()
}