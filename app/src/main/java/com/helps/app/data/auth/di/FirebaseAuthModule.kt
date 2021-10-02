package com.helps.app.data.auth.di

import com.helps.app.data.auth.service.AuthAPI
import com.helps.app.data.auth.service.FirebaseAuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class FirebaseAuthModule {

    @Provides
    fun provideFirebaseAuthService(): AuthAPI = FirebaseAuthService()
}