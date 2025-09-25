package com.example.dailypulse

data class ArticleState (

    val articleList : List<Article> = listOf(),
    val loading : Boolean = false,
    val error : String? = null

)
