package com.helps.navigation.di

import com.helps.navigation.HelpsNavigator
import com.helps.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigatorModule {

    @Provides
    @Singleton
    fun provideNavigator(scope: CoroutineScope): Navigator = HelpsNavigator(scope)

    @Provides
    fun provideScope(): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
}