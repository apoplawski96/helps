package com.helps.app.domain.auth.di

import com.helps.app.data.auth.service.login.LoginAPI
import com.helps.app.data.auth.service.logout.LogoutAPI
import com.helps.app.data.auth.service.register.RegisterAPI
import com.helps.app.data.auth.service.user.UserAPI
import com.helps.app.domain.auth.model.AuthAPI
import com.helps.app.domain.auth.repository.FirebaseUserRepository
import com.helps.app.domain.auth.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object UserRepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideFirebaseUserRepository(
        loginAPI: LoginAPI,
        registerAPI: RegisterAPI,
        logoutAPI: LogoutAPI,
        userAPI: UserAPI,
    ): UserRepository =
        FirebaseUserRepository(
            userAPI = userAPI,
            firebaseLoginService = loginAPI,
            firebaseRegisterService = registerAPI,
            firebaseLogoutService = logoutAPI
        )
}