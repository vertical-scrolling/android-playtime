package com.hackathon.playtime.data.datasource.api

import com.hackathon.playtime.data.datasource.remote.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET

interface PlatformApi {

    @GET("/1/platforms")
    suspend fun getPlatforms(): Response<List<PlatformResponse>>
}