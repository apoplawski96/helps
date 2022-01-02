package com.helps.app.data.database.service.add

import com.google.firebase.firestore.FirebaseFirestore
import com.helps.app.domain.helps.common.HelpsDatabaseConstants
import com.helps.app.domain.helps.common.model.HelpsData
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AddHelpsFirestoreService @Inject constructor(
    firestoreInstance: FirebaseFirestore
) : AddHelpsAPI {

    private val collectionName = HelpsDatabaseConstants.HelpsCollection.name
    private val collectionPath = firestoreInstance.collection(collectionName)

    override suspend fun invoke(
        helpsData: HelpsData,
    ): AddHelpsAPI.Result = suspendCoroutine { continuation ->
        collectionPath.document(helpsData.id).set(helpsData).addOnSuccessListener {
            continuation.resume(AddHelpsAPI.Result.Success)
        }.addOnFailureListener {
            continuation.resume(AddHelpsAPI.Result.Error(it))
        }
    }

    override fun createHelpsRecordReference(): String = collectionPath.document().id
}