package com.helps.app.data.database.service.get

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.toObject
import com.helps.app.domain.debug.log
import com.helps.app.domain.helps.common.HelpsDatabaseConstants
import com.helps.app.domain.helps.common.model.HelpsData
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GetHelpsFirestoreService @Inject constructor(
    firestoreInstance: FirebaseFirestore
) : GetHelpsAPI {

    private val collectionName = HelpsDatabaseConstants.HelpsCollection.name
    private val collectionPath = firestoreInstance.collection(collectionName)

    override suspend fun getAll(): GetHelpsAPI.Result = suspendCoroutine { continuation ->
        collectionPath.get().addOnSuccessListener { documents ->
            val output = documents.map { it.toHelpsData() }
            continuation.resume(GetHelpsAPI.Result.Success(values = output))
            log("success: $output")
        }.addOnFailureListener {
            continuation.resume(GetHelpsAPI.Result.Error(it))
            log("failure")
        }
    }

    private fun QueryDocumentSnapshot.toHelpsData(): HelpsData = this.toObject()
}