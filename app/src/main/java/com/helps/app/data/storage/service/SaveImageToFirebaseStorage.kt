package com.helps.app.data.storage.service

import com.google.firebase.storage.FirebaseStorage
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class SaveImageToFirebaseStorage @Inject constructor(
    private val storageInstance: FirebaseStorage,
    private val storagePathBuilder: StoragePathBuilder
) : SaveImageAPI {

    override suspend fun invoke(
        id: String,
        type: StoragePathBuilder.Type,
        imageBytes: ByteArray
    ): SaveImageAPI.Result = suspendCoroutine { continuation ->
        val storagePath = storagePathBuilder.build(id = id, type = type)
        val uploadTask = storageInstance.reference.child(storagePath).putBytes(imageBytes)

        uploadTask.addOnSuccessListener {
            continuation.resume(SaveImageAPI.Result.Success)
        }.addOnFailureListener {
            continuation.resume(SaveImageAPI.Result.Error(it))
        }
    }
}