package com.hackathon.playtime.data.datasource.api

import com.hackathon.playtime.data.datasource.remote.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlatformApi {

    @GET("/1/platforms")
    suspend fun getPlatforms(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("order") order: String
    ): Response<List<PlatformResponse>>
}