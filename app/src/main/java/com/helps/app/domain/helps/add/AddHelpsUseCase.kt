package com.helps.app.domain.helps.add

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.res.ResourcesCompat
import com.helps.app.R
import com.helps.app.data.database.service.add.AddHelpsAPI
import com.helps.app.data.storage.service.SaveImageAPI
import com.helps.app.data.storage.service.StoragePathBuilder
import com.helps.app.domain.helps.common.model.HelpsData
import com.helps.app.domain.helps.common.model.Timestamp
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import javax.inject.Inject

class AddHelpsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val addHelpsAPI: AddHelpsAPI,
    private val saveImageAPI: SaveImageAPI,
) {

    sealed class Result {
        object Success : Result()
        data class Error(val exception: Exception) : Result()
    }

    suspend operator fun invoke(data: HelpsData): Result = withContext(Dispatchers.Default) {
        val helpsId = addHelpsAPI.createHelpsRecordReference()

        val addHelpsToDatabase = async {
            addHelpsAPI(helpsData = data.assignId(helpsId).addTimestamp(Timestamp(2137)))
        }
        val saveImageToStorage = async {
            saveImageAPI(
                id = helpsId,
                type = StoragePathBuilder.Type.HelpsImage,
                imageBytes = getImageInBytesArray()
            )
        }

        val databaseResult = addHelpsToDatabase.await()
        val storageResult = saveImageToStorage.await()

        if (databaseResult is AddHelpsAPI.Result.Error || storageResult is SaveImageAPI.Result.Error) {
            return@withContext Result.Error(Exception("Something wrong"))
        }

        Result.Success
    }

    private fun HelpsData.assignId(id: String): HelpsData =
        this.copy(id = id)

    private fun HelpsData.addTimestamp(timestamp: Timestamp): HelpsData =
        this.copy(timestamp = timestamp)

    // TODO: Extract somewhere
    private fun getImageInBytesArray(): ByteArray {
        val imageRes = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.helps_logo,
            null
        ) as BitmapDrawable
        val bitmap = imageRes.bitmap
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        return bytes.toByteArray()
    }
}