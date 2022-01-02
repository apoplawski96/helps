package com.helps.app.presentation.helps.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helps.app.domain.helps.common.model.HelpsData
import com.helps.app.domain.helps.get.GetHelpsUseCase
import com.helps.app.presentation.helps.common.converter.HelpsItemUIConverter
import com.helps.app.presentation.helps.common.model.HelpsItemUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchHelpsViewModel @Inject constructor(
    private val getHelpsUseCase: GetHelpsUseCase,
    private val converter: HelpsItemUIConverter,
) : ViewModel() {

    private val _helpsList: MutableStateFlow<List<HelpsItemUI>> = MutableStateFlow(listOf())
    val helpsList: StateFlow<List<HelpsItemUI>> = _helpsList

    fun downloadAll() {
        viewModelScope.launch {
            getHelpsUseCase().handleResult()
        }
    }

    private suspend fun GetHelpsUseCase.Result.handleResult() {
        when (this) {
            is GetHelpsUseCase.Result.Success -> {
                _helpsList.emit(value = this.values.toHelpsUIItems())
            }
            is GetHelpsUseCase.Result.Error -> {
                Log.d("2137", "${this@SearchHelpsViewModel} - Error: ${this.exception}")
            }
        }
    }

    private fun List<HelpsData>.toHelpsUIItems(): List<HelpsItemUI> = converter.convert(this)
}

