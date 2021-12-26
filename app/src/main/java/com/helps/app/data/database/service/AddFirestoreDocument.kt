package com.helps.app.data.database.service

import com.google.firebase.firestore.FirebaseFirestore
import com.helps.app.domain.helps.common.model.HelpsData
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AddFirestoreDocument @Inject constructor(
    private val firestoreInstance: FirebaseFirestore
) : AddDocumentAPI {

    override suspend fun invoke(
        data: HashMap<String, String>,
        collectionName: String
    ): AddDocumentAPI.Result = suspendCoroutine { continuation ->
        firestoreInstance.collection(collectionName)
            .add(data)
            .addOnSuccessListener {
                if (it.get().isSuccessful) {
                    continuation.resume(AddDocumentAPI.Result.Success(documentSnapshot = it.get().result))
                }
            }
            .addOnFailureListener {
                continuation.resume(AddDocumentAPI.Result.Error(it))
            }
    }

    override suspend fun asObject(
        helpsData: HelpsData,
        collectionName: String
    ): AddDocumentAPI.Result = suspendCoroutine { continuation ->
        firestoreInstance.collection(collectionName)
            .add(helpsData)
            .addOnSuccessListener {
                if (it.get().isSuccessful) {
                    continuation.resume(AddDocumentAPI.Result.Success(documentSnapshot = it.get().result))
                }
            }
            .addOnFailureListener {
                continuation.resume(AddDocumentAPI.Result.Error(it))
            }
    }
}