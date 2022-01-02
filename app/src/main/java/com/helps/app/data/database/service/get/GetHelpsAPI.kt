package com.helps.app.data.database.service.get

import com.helps.app.domain.helps.common.model.HelpsData

interface GetHelpsAPI {

    sealed class Result {
        data class Success(val values: List<HelpsData>) : Result()
        data class Error(val exception: Exception = Exception()) : Result()
    }

    suspend fun getAll(): Result

    suspend fun getById(id: String): Result
}