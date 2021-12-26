package com.helps.app.domain.helps.common.model

data class HelpsData(
    val id: String = "",
    val userUuid: String = "",
    val description: String = "",
    val hashtags: Hashtags = Hashtags(value = listOf()),
    val timestamp: Timestamp = Timestamp(value = 1L),
    val location: Location = Location(),
)
