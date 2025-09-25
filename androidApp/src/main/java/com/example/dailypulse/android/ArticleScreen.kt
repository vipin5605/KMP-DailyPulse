package com.example.dailypulse.android

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dailypulse.Article
import com.example.dailypulse.ArticleViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ArticleScreen(articleViewModel: ArticleViewModel = getViewModel()) {

    val articleState = articleViewModel.articleState.collectAsState()

    Column {
        
        AppToolBar(title = "Article List")

        if (articleState.value.loading) {

            ArticleLoading()

        } else if (articleState.value.error != null) {

            ArticleLoadingError(articleState.value.error!!)

        } else if (articleState.value.articleList.isNotEmpty()) {
            
            ArticleLoaded(articleState.value.articleList)

        }
    }

}

@Composable
fun ArticleLoaded(articleList: List<Article>) {
    LazyColumn {

        items(articleList) { article ->

            ArticleItemView(article)

        }
    }
}

@Composable
fun ArticleItemView(article: Article) {

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
        )
        
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 23.sp))

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = article.desc,
            style = TextStyle(fontSize = 15.sp))
        
        Text(text = article.date, style = TextStyle(fontSize = 10.sp), modifier = Modifier.align(Alignment.End))


    }

}

@Composable
fun ArticleLoadingError(error: String) {
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center) {
        Text(text = error,
            style = TextStyle(fontSize = 12.sp, textAlign = TextAlign.Center)
        )
    }

}

@Composable
fun ArticleLoading() {

    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary)
    }
}
