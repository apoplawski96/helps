package com.helps.app.domain.helps.add

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.toObject
import com.helps.app.data.database.service.AddDocumentAPI
import com.helps.app.domain.helps.common.HelpsDatabaseConstants
import com.helps.app.domain.helps.common.model.HelpsData
import javax.inject.Inject

class AddHelps @Inject constructor(
    private val addDocumentAPI: AddDocumentAPI
) {

    private val keys = HelpsDatabaseConstants.HelpsCollection.Keys

    sealed class Result {
        data class Success(val helpsData: HelpsData?) : Result()
        data class Error(val exception: Exception) : Result()
    }

    suspend operator fun invoke(data: HelpsData): Result = addDocumentAPI.asObject(
        helpsData = data,
        collectionName = HelpsDatabaseConstants.HelpsCollection.name
    ).handleResult()

    private fun HelpsData.toDocumentHashMap(): HashMap<String, String> {
        return hashMapOf(
            keys.KEY_USER_UUID to userUuid,
            keys.KEY_DESCRIPTION to description,
            keys.KEY_HASHTAGS to hashtags.toString(),
            keys.LOCATION to location.toString(),
            keys.PHOTOS to photos.toString(),
            keys.TIMESTAMP to timestamp.toString()
        )
    }

    private fun DocumentSnapshot?.toHelpsData(): HelpsData? = this?.toObject<HelpsData>()

    private fun AddDocumentAPI.Result.handleResult(): Result = when (this) {
        is AddDocumentAPI.Result.Success -> Result.Success(this.documentSnapshot.toHelpsData())
        is AddDocumentAPI.Result.Error -> Result.Error(this.exception)
    }
}