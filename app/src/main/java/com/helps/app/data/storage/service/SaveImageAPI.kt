package com.helps.app.data.storage.service

interface SaveImageAPI {

    sealed class Result {
        object Success : Result()
        data class Error(val exception: Exception) : Result()
    }

    suspend operator fun invoke(
        id: String,
        type: StoragePathBuilder.Type,
        imageBytes: ByteArray
    ): Result
}