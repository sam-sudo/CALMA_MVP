package com.ck.calma.di

import presentation.post.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PostViewModel(get()) }
}