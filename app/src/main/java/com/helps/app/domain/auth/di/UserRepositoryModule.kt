package com.helps.app.domain.auth.di

import com.helps.app.data.auth.service.AuthAPI
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
    fun provideFirebaseUserRepository(authAPI: AuthAPI): UserRepository =
        FirebaseUserRepository(authAPI)
}