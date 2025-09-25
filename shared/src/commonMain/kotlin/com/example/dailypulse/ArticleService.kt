package com.example.dailypulse

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {

    private val country = "us"

    private val category = "business"

    private val apiKey = "c9ec88f829c540fc9c4268035ee2cc87"

    suspend fun fetchArticles() : List<ArticleRaw> {
        val response : ArticleResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=c9ec88f829c540fc9c4268035ee2cc87").body()
        return response.articles
    }
}