package com.example.dailypulse

import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    val title : String?,
    val description : String?,
    val publishedAt : String?,
    val urlToImage: String?
)
