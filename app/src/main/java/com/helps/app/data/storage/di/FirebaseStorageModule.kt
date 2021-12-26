package com.helps.app.data.storage.di

import com.google.firebase.storage.FirebaseStorage
import com.helps.app.data.storage.service.SaveImageAPI
import com.helps.app.data.storage.service.SaveImageToFirebaseStorage
import com.helps.app.data.storage.service.StoragePathBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class FirebaseStorageModule {

    @Provides
    fun provideFirebaseStorageInstance(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    fun provideSaveImageToStorage(
        storageInstance: FirebaseStorage,
        storagePathBuilder: StoragePathBuilder,
    ): SaveImageAPI = SaveImageToFirebaseStorage(storageInstance, storagePathBuilder)
}