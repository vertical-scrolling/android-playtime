package com.hackathon.playtime.domain.interactor.repository

import com.hackathon.playtime.data.datasource.api.GameApi
import com.hackathon.playtime.data.datasource.remote.GameDetailsResponse
import com.hackathon.playtime.data.datasource.remote.GameResponse
import com.hackathon.playtime.data.repository.GameRepository
import com.hackathon.playtime.utils.OrderByEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRepositoryImpl(private val gameApi: GameApi) : GameRepository {

    companion object {
        private const val DEFAULT_PAGE = 1
        private const val DEFAULT_PAGE_SIZE = 25
    }

    override suspend fun getGames(
        genreFilter: String,
        platformFilter: String,
        storeFilter: String,
        ratingFilter: String,
        page: Int,
        pageSize: Int,
        order: OrderByEnum?
    ) = withContext(Dispatchers.IO) {
        try {
            val gamesResponse = gameApi.getGames(
                genreFilter,
                platformFilter,
                storeFilter,
                ratingFilter,
                page,
                pageSize,
                order
            )
            gamesResponse.body() ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getGameDetails(id: Int): GameDetailsResponse {
        TODO("Not yet implemented")
    }


}