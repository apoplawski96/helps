package com.helps.app.data.database.service

import com.google.firebase.firestore.DocumentSnapshot
import com.helps.app.domain.helps.common.model.HelpsData

interface AddDocumentAPI {

    sealed class Result {
        data class Success(val documentSnapshot: DocumentSnapshot?) : Result()
        data class Error(val exception: Exception = Exception()) : Result()
    }

    suspend operator fun invoke(data: HashMap<String, String>, collectionName: String): Result

    suspend fun asObject(helpsData: HelpsData, collectionName: String): Result
}