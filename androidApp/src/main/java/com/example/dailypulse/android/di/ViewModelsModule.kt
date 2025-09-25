package com.example.dailypulse.android.di

import com.example.dailypulse.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        ArticleViewModel(get())
    }

}