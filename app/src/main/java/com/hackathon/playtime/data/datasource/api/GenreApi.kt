package com.hackathon.playtime.data.datasource.api

import com.hackathon.playtime.data.datasource.remote.GenreResponse
import com.hackathon.playtime.data.datasource.remote.StoreResponse
import retrofit2.Response
import retrofit2.http.GET

interface GenreApi {

    @GET("/1/genres")
    suspend fun getGenres(): Response<List<GenreResponse>>

}