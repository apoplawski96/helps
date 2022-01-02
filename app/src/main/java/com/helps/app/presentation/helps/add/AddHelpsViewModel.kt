package com.helps.app.presentation.helps.add

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.app.domain.auth.repository.UserRepository
import com.helps.app.domain.helps.add.AddHelpsUseCase
import com.helps.app.domain.helps.common.model.HelpsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddHelpsViewModel @Inject constructor(
    private val addHelps: AddHelpsUseCase,
    private val userRepository: UserRepository
) : ViewModel() {

    fun addHelps(helpsData: HelpsData) {
        viewModelScope.launch {
            addHelps.invoke(helpsData.applyMetadata()).handleResult()
        }
    }

    private suspend fun AddHelpsUseCase.Result.handleResult() {
        when(this) {
            is AddHelpsUseCase.Result.Success -> {
                Log.d("2137", "succ")
            }
            is AddHelpsUseCase.Result.Error -> {
                Log.d("2137", "err")
            }
        }
    }

    private fun HelpsData.applyMetadata(): HelpsData = this.copy(
        userUuid = userRepository.user.value?.uuid ?: "ERROR: NO USER ID"
    )
}