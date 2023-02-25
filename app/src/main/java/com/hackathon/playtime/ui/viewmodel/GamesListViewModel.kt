package com.hackathon.playtime.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackathon.playtime.domain.interactor.usecase.GetGamesUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetGenresUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetPlatformsUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetStoresUseCase
import com.hackathon.playtime.domain.model.GameSummary
import com.hackathon.playtime.domain.model.Genre
import com.hackathon.playtime.domain.model.Platform
import com.hackathon.playtime.domain.model.Store
import com.hackathon.playtime.utils.GamesListStatus


class GamesListViewModel(
    private val getGames: GetGamesUseCase,
    private val getGenres: GetGenresUseCase,
    private val getPlatforms: GetPlatformsUseCase,
    private val getStores: GetStoresUseCase
) : ViewModel() {

    private val _gamesListStatus = MutableLiveData<GamesListStatus>()
    private val _gamesLiveData = MutableLiveData<List<GameSummary>>()
    private val _genresLiveData = MutableLiveData<List<Genre>>()
    private val _platformsLiveData = MutableLiveData<List<Platform>>()
    private val _storesLiveData = MutableLiveData<List<Store>>()

    fun getGamesListStatus() = _gamesListStatus as MutableLiveData<GamesListStatus>
    fun getGamesLiveData() = _gamesLiveData as MutableLiveData<List<GameSummary>>
    fun getGenresLiveData() = _genresLiveData as MutableLiveData<List<Genre>>
    fun getPlatformsLiveData() = _platformsLiveData as MutableLiveData<List<Platform>>
    fun getStoresLiveData() = _storesLiveData as MutableLiveData<List<Store>>

    fun setUp() {

    }
}