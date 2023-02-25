package com.hackathon.playtime.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.hackathon.playtime.domain.interactor.usecase.GetGamesUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetGenresUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetPlatformsUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetStoresUseCase

class GamesListViewModel(
    private val getGames: GetGamesUseCase,
    private val getGenres: GetGenresUseCase,
    private val getPlatforms: GetPlatformsUseCase,
    private val getStores: GetStoresUseCase
) : ViewModel() {


}