package com.helps.app.data.auth.di

import com.google.firebase.auth.FirebaseAuth
import com.helps.app.data.auth.service.login.FirebaseLoginService
import com.helps.app.data.auth.service.login.LoginAPI
import com.helps.app.data.auth.service.logout.FirebaseLogoutService
import com.helps.app.data.auth.service.logout.LogoutAPI
import com.helps.app.data.auth.service.register.FirebaseRegisterService
import com.helps.app.data.auth.service.register.RegisterAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class FirebaseAuthModule {

    @Provides
    fun provideFirebaseAuthInstance(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideRegisterService(firebaseAuthInstance: FirebaseAuth): RegisterAPI = FirebaseRegisterService(firebaseAuthInstance)

    @Provides
    fun provideLoginService(firebaseAuthInstance: FirebaseAuth): LoginAPI = FirebaseLoginService(firebaseAuthInstance)

    @Provides
    fun provideLogoutService(firebaseAuthInstance: FirebaseAuth): LogoutAPI = FirebaseLogoutService(firebaseAuthInstance)
}