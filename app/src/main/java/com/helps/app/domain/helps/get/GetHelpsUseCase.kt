package com.helps.app.domain.helps.get

import com.helps.app.data.database.service.get.GetHelpsAPI
import com.helps.app.domain.helps.common.model.HelpsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetHelpsUseCase @Inject constructor(
    private val getHelpsAPI: GetHelpsAPI
) {

    sealed class Result {
        data class Success(val values: List<HelpsData>) : Result()
        data class Error(val exception: Exception = Exception()) : Result()
    }

    suspend operator fun invoke(): Result = withContext(Dispatchers.Default) {
        return@withContext when (val result = getHelpsAPI.getAll()) {
            is GetHelpsAPI.Result.Success -> {
                Result.Success(values = result.values)
            }
            is GetHelpsAPI.Result.Error -> {
                Result.Error(exception = result.exception)
            }
        }
    }
}