package com.helps.app.data.database.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.helps.app.data.database.service.add.AddHelpsFirestoreService
import com.helps.app.data.database.service.add.AddHelpsAPI
import com.helps.app.data.database.service.get.GetHelpsFirestoreService
import com.helps.app.data.database.service.get.GetHelpsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class FirebaseFirestoreModule {

    @Provides
    fun provideFirebaseFirestoreInstance(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideAddDocumentService(firestoreInstance: FirebaseFirestore): AddHelpsAPI = AddHelpsFirestoreService(firestoreInstance)

    @Provides
    fun provideGetHelpsService(firestoreInstance: FirebaseFirestore): GetHelpsAPI = GetHelpsFirestoreService(firestoreInstance)
}