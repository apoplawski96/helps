package com.helps.app.domain.auth.repository

import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.data.auth.service.login.LoginAPI
import com.helps.app.data.auth.service.logout.LogoutAPI
import com.helps.app.data.auth.service.register.RegisterAPI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FirebaseUserRepository @Inject constructor(
        private val firebaseLoginService: LoginAPI,
        private val firebaseRegisterService: RegisterAPI,
        private val firebaseLogoutService: LogoutAPI
) : UserRepository {

    @ExperimentalCoroutinesApi
    override suspend fun createUserWithEmailAndPassword(
            email: String,
            password: String
    ): Flow<AuthAPI.Result> = firebaseRegisterService.createAccountWithEmailAndPassword(email, password)

    @ExperimentalCoroutinesApi
    override suspend fun signInWithEmailAndPassword(
            email: String,
            password: String
    ): Flow<AuthAPI.Result> = firebaseLoginService.signInWithEmailAndPassword(email, password)

    @ExperimentalCoroutinesApi
    override suspend fun logout(): Flow<AuthAPI.Result> = firebaseLogoutService.logout()
}