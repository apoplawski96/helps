package com.helps.presentation.helps

data class HelpsItemContent(
    val id: String,
    val title: String,
    val summary: String,
    val location: String,
    val datePublished: String,
    val imageUrl: String,
    val sponsored: Boolean
)
