package com.helps.app.ui.helps.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.app.domain.debug.log
import com.helps.app.domain.helps.common.model.HelpsData
import com.helps.app.domain.helps.get.GetHelpsByIdUseCase
import com.helps.app.ui.helps.common.converter.HelpsItemUIConverter
import com.helps.app.ui.helps.common.model.HelpsItemUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HelpsDetailViewModel @Inject constructor(
    private val getHelps: GetHelpsByIdUseCase,
    private val converter: HelpsItemUIConverter,
) : ViewModel() {

    private val _helpsItem: MutableSharedFlow<HelpsItemUI> = MutableSharedFlow()
    val helpsItem: SharedFlow<HelpsItemUI> = _helpsItem

    fun download(id: String) {
        viewModelScope.launch {
            getHelps(id).handleResult()
        }
    }

    private suspend fun GetHelpsByIdUseCase.Result.handleResult() {
        when (this) {
            is GetHelpsByIdUseCase.Result.Success -> {
                _helpsItem.emit(value = this.values.first().toHelpsUIItem())
            }
            is GetHelpsByIdUseCase.Result.Error -> {
                log("${this@HelpsDetailViewModel} - Error: ${this.exception}")
            }
        }
    }

    private fun HelpsData.toHelpsUIItem(): HelpsItemUI = converter.convertItem(this)
}

