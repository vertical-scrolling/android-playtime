package com.hackathon.playtime.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.playtime.domain.interactor.usecase.GetGameDetailsUseCase
import com.hackathon.playtime.domain.model.GameDetails
import com.hackathon.playtime.utils.GameDetailsStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameDetailsViewModel(
    private val getGameDetailsUseCase: GetGameDetailsUseCase
): ViewModel() {

    private val _gameDetailsStatus = MutableLiveData<GameDetailsStatus>()
    private val _gameLiveData = MutableLiveData<GameDetails>()

    fun getGameDetailsStatus() = _gameDetailsStatus
    fun getGameDetails() = _gameLiveData

    fun setUp(gameId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            getGameDetailsUseCase(gameId.toString()).let { gameDetails ->
                _gameLiveData.postValue(gameDetails)
            }
        }
    }
}