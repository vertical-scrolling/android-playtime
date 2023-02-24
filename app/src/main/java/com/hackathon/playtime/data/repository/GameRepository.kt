package com.hackathon.playtime.data.repository

import com.hackathon.playtime.data.datasource.remote.GameDetailsResponse
import com.hackathon.playtime.data.datasource.remote.GameResponse
import com.hackathon.playtime.utils.OrderByEnum

interface GameRepository {

    suspend fun getGames(
        genreFilter: String,
        platformFilter: String,
        storeFilter: String,
        ratingFilter: String,
        page: Int,
        pageSize: Int,
        order: OrderByEnum?
    ): List<GameResponse>

    suspend fun getGameDetails(id: Int): GameDetailsResponse

}