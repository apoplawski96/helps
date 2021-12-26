package com.helps.app.data.database.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.helps.app.data.database.service.AddHelpsToDatabase
import com.helps.app.data.database.service.AddHelpsToFirestoreDatabase
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
    fun provideAddDocumentService(firestoreInstance: FirebaseFirestore): AddHelpsToDatabase = AddHelpsToFirestoreDatabase(firestoreInstance)
}