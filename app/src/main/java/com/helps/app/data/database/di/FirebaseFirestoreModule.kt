package com.helps.app.data.database.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.helps.app.data.auth.service.register.FirebaseRegisterService
import com.helps.app.data.auth.service.register.RegisterAPI
import com.helps.app.data.database.service.AddDocumentAPI
import com.helps.app.data.database.service.AddFirestoreDocument
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
    fun provideAddDocumentService(firestoreInstance: FirebaseFirestore): AddDocumentAPI = AddFirestoreDocument(firestoreInstance)
}