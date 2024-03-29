package com.helps.app.data.database.service.add

import com.helps.app.domain.helps.common.model.HelpsData

interface AddHelpsAPI {

    sealed class Result {
        object Success : Result()
        data class Error(val exception: Exception = Exception()) : Result()
    }

    suspend operator fun invoke(helpsData: HelpsData): Result

    fun createHelpsRecordReference(): String
}