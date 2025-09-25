package com.example.dailypulse.di

import com.example.dailypulse.ArticleService
import com.example.dailypulse.ArticleUseCase
import com.example.dailypulse.ArticleViewModel
import org.koin.dsl.module

val articleModule = module {

    single<ArticleService> { ArticleService(get()) }
    single<ArticleUseCase> { ArticleUseCase(get()) }
    single<ArticleViewModel> { ArticleViewModel(get()) }
}