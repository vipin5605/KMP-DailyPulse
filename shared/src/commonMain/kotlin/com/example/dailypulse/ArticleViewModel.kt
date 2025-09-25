package com.example.dailypulse

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticleViewModel(private val articleUseCase : ArticleUseCase) : BaseViewModel() {

    private val _articleState : MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState())

    val articleState : StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }


    private fun getArticles() {
        scope.launch {
            val articles = articleUseCase.getArticles()
            _articleState.emit(ArticleState(articleList = articles))
        }
    }

}