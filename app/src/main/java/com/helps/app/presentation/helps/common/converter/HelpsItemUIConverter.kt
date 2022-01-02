package com.helps.app.presentation.helps.common.converter

import com.helps.app.domain.helps.common.model.HelpsData
import com.helps.app.presentation.helps.common.model.HelpsItemUI
import javax.inject.Inject

class HelpsItemUIConverter @Inject constructor() {

    fun convert(items: List<HelpsData>): List<HelpsItemUI> = items.map {
        HelpsItemUI(
            id = it.id,
            title = it.title,
            summary = it.description,
            location = it.location.value,
            datePublished = it.timestamp.value.toDisplayDate(),
            imageUrl = "", // TODO: think about it
            sponsored = it.isSponsored
        )
    }

    private fun Long.toDisplayDate(): String = this.toString()
}
