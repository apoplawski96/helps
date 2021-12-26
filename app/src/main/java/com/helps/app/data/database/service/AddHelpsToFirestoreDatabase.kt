package com.helps.app.data.database.service

import com.google.firebase.firestore.FirebaseFirestore
import com.helps.app.domain.helps.common.HelpsDatabaseConstants
import com.helps.app.domain.helps.common.model.HelpsData
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AddHelpsToFirestoreDatabase @Inject constructor(
    firestoreInstance: FirebaseFirestore
) : AddHelpsToDatabase {

    private val collectionName = HelpsDatabaseConstants.HelpsCollection.name
    private val collectionPath = firestoreInstance.collection(collectionName)

    override suspend fun invoke(
        helpsData: HelpsData,
    ): AddHelpsToDatabase.Result = suspendCoroutine { continuation ->
        collectionPath.document(helpsData.id).set(helpsData).addOnSuccessListener {
            continuation.resume(AddHelpsToDatabase.Result.Success)
        }.addOnFailureListener {
            continuation.resume(AddHelpsToDatabase.Result.Error(it))
        }
    }

    override fun createHelpsRecordReference(): String = collectionPath.document().id
}