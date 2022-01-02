package com.helps.app.presentation.helps.common.model

data class HelpsItemUI(
    val id: String,
    val title: String,
    val summary: String,
    val location: String,
    val datePublished: String,
    val imageUrl: String,
    val sponsored: Boolean
)
