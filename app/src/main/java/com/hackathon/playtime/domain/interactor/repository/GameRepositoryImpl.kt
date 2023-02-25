package com.hackathon.playtime.domain.interactor.repository

import android.util.Log
import com.hackathon.playtime.data.datasource.api.GameApi
import com.hackathon.playtime.data.datasource.remote.GameDetailsResponse
import com.hackathon.playtime.data.datasource.remote.GameMedia
import com.hackathon.playtime.data.datasource.remote.GameResponse
import com.hackathon.playtime.data.repository.GameRepository
import com.hackathon.playtime.domain.model.toEntity
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
            gamesResponse.body()?.games ?: emptyList()
        } catch (e: Exception) {
            Log.e("GameRepo", "getGames error: $e")
            emptyList()
        }
    }

    override suspend fun getGameDetails(id: String): GameDetailsResponse = withContext(Dispatchers.IO) {
        val emptyGame = GameDetailsResponse(
                id = 0,
                name = "",
                description = "",
                released = "",
                rating = 0.0,
                media = GameMedia(
                    url = ""
                ),
                playtime = 0,
                status = ""
        )
        try {
            val gameDetailsResponse = gameApi.getGameDetails(id)
            gameDetailsResponse.body() ?: emptyGame
        } catch (e: Exception) {
            Log.e("GameRepo", "getGames error: $e")
            emptyGame
        }
    }


}