package com.hackathon.playtime.ui.viewmodel

import com.hackathon.playtime.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MainViewModel() }
    viewModel { GamesListViewModel(get(), get(), get(), get()) }
}