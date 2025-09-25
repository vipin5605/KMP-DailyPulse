package com.example.dailypulse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val status : String,
    @SerialName("totalResults")
    val totalCount : Int,
    val articles : List<ArticleRaw>
)
