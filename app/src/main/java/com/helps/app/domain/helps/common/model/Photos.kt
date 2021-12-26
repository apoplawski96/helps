package com.helps.app.domain.helps.common.model

data class Photos(
    val urls: List<String> = emptyList(),
    val firstPhotoUrl: String = ""
)
