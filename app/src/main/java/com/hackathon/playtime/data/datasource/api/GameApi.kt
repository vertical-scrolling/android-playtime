package com.hackathon.playtime.data.datasource.api

import com.hackathon.playtime.data.datasource.remote.GameDetailsResponse
import com.hackathon.playtime.data.datasource.remote.GameObjectResponse
import com.hackathon.playtime.data.datasource.remote.GameResponse
import com.hackathon.playtime.utils.OrderByEnum
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApi {

    @GET("/1/games")
    suspend fun getGames(
        @Query("genre") genre: String?,
        @Query("platform") platform: String?,
        @Query("store") store: String?,
        @Query("rating") rating: String?,
        @Query("page") page: Int?,
        @Query("pageSize") pageSize: Int?,
        @Query("order") order: OrderByEnum?
    ): Response<GameObjectResponse>

    @GET("/1/games/{gameId}")
    suspend fun getGameDetails(@Path("gameId") gameId: String): Response<GameDetailsResponse>
}
