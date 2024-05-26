package com.ck.calma.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.Products.ProductViewModel

val appModule = module {
    viewModel { ProductViewModel(get()) }
}