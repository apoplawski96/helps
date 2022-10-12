package com.helps.app.domain.helps.common.model

import com.helps.app.domain.auth.model.HelpsUser

data class HelpsData(
    val id: String = "",
    val userUuid: String = "",
    val title: String = "",
    val description: String = "",
    val hashtags: Hashtags = Hashtags(value = listOf()),
    val timestamp: Timestamp = Timestamp(value = 1L),
    val location: Location = Location(),
    val isSponsored: Boolean = false,
    val userPosted: HelpsUser = HelpsUser()
)
