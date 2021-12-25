package com.helps.app.domain.auth.repository

import android.util.Log
import com.google.firebase.auth.FirebaseUser
import com.helps.app.data.auth.service.login.LoginAPI
import com.helps.app.data.auth.service.logout.LogoutAPI
import com.helps.app.data.auth.service.register.RegisterAPI
import com.helps.app.data.auth.service.user.UserAPI
import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.domain.auth.model.HelpsUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class FirebaseUserRepository @Inject constructor(
    private val userAPI: UserAPI,
    private val firebaseLoginService: LoginAPI,
    private val firebaseRegisterService: RegisterAPI,
    private val firebaseLogoutService: LogoutAPI,
) : UserRepository {

    private val _user: MutableStateFlow<HelpsUser?> = MutableStateFlow(getFirebaseUser())
    override val user: StateFlow<HelpsUser?> = _user

    @ExperimentalCoroutinesApi
    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> =
        firebaseRegisterService.createAccountWithEmailAndPassword(email, password)

    @ExperimentalCoroutinesApi
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<AuthAPI.Result> = firebaseLoginService.signInWithEmailAndPassword(email, password)

    override suspend fun updateUserState(result: AuthAPI.Result) {
        Log.d("2137", "updateUserState()")
        emitUserState()
    }

    override suspend fun logout() {
        firebaseLogoutService.logout().also { emitUserState() }
    }

    private fun getFirebaseUser() = userAPI.getCurrentUser().toHelpsUser()

    private fun FirebaseUser?.toHelpsUser() = if (this == null) {
        this
    } else {
        HelpsUser(uuid = this.uid, name = this.displayName ?: "")
    }

    private suspend fun emitUserState() {
        _user.emit(getFirebaseUser())
        Log.d("2137", "emitUserState() -> ${getFirebaseUser()}")
    }
}