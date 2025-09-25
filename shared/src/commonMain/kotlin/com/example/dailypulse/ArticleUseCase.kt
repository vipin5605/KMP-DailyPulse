package com.example.dailypulse

class ArticleUseCase(private val service : ArticleService) {

    suspend fun getArticles() : List<Article> {
        val articles = service.fetchArticles()
        return mapArticles(articles)


    }

    private fun mapArticles(articles: List<ArticleRaw>): List<Article> = articles.map { raw ->

        Article(title = raw.title?:"title", desc = raw.description?:"eee", date = raw.publishedAt?:"" , imageUrl = raw.urlToImage?:"")
    }

    /*@OptIn(ExperimentalTime::class)
    private fun getFormattedDate(date: String): String {
        val today = System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date)
        val result = when {

            abs(days) > 1 -> "${abs(days)} days ago"

            abs(days) == 1 -> "Yesterday"


            else -> { "Today" }
        }

        return result

    }*/
}