package com.helps.app.ui.helps.common.converter

import com.helps.app.domain.helps.common.model.HelpsData
import com.helps.app.ui.helps.common.model.HelpsItemUI
import javax.inject.Inject

class HelpsItemUIConverter @Inject constructor() {

    fun convertItem(item: HelpsData): HelpsItemUI = HelpsItemUI(
        id = item.id,
        title = "Potrzebna pomoc przy wniesieniu szafy",
        summary = "Potrzebna pomoc przy wniesieniu szafy, centrum Wroclawia. Platne 50 zł od osoby, kontakt priv",
        location = item.location.value,
        datePublished = item.timestamp.value.toDisplayDate(),
        imageUrl = "", // TODO: think about it
        sponsored = item.isSponsored
    )

    fun convertList(items: List<HelpsData>): List<HelpsItemUI> = items.map {
        convertItem(it)
    }

    private fun Long.toDisplayDate(): String = "Today, 16:27"
}
