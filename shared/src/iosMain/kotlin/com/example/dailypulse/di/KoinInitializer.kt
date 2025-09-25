package com.example.dailypulse.di

import com.example.dailypulse.ArticleViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModule

    startKoin { modules(modules) }
}

class ArticleInjector : KoinComponent {
    val articleViewModel : ArticleViewModel by inject()
}