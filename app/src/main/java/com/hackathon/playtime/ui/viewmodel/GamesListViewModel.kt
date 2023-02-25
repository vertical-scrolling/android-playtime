package com.hackathon.playtime.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.playtime.domain.interactor.usecase.GetGamesUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetGenresUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetPlatformsUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetStoresUseCase
import com.hackathon.playtime.domain.model.GameSummary
import com.hackathon.playtime.domain.model.Genre
import com.hackathon.playtime.domain.model.Platform
import com.hackathon.playtime.domain.model.Store
import com.hackathon.playtime.utils.GamesListStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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

    fun getGamesListStatus() = _gamesListStatus
    fun getGamesLiveData() = _gamesLiveData
    fun getGenresLiveData() = _genresLiveData
    fun getPlatformsLiveData() = _platformsLiveData
    fun getStoresLiveData() = _storesLiveData

    fun setUp() {
        val filters: Map<String,String> = emptyMap()

        viewModelScope.launch(Dispatchers.IO) {
            getGames(filters, 1, 10, null).let { games ->
                _gamesLiveData.postValue(games)
            }

            getGenres().let { genres ->
                _genresLiveData.postValue(genres)
            }
            getPlatforms().let { platforms ->
                _platformsLiveData.postValue(platforms)
            }
            getStores().let { stores ->
                _storesLiveData.postValue(stores)
            }
        }


    }
}