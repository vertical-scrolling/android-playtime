package com.hackathon.playtime.data.datasource.api

import com.hackathon.playtime.data.datasource.remote.StoreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StoreApi {

    @GET("/1/stores")
    suspend fun getStores(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("order") order: String
    ): Response<List<StoreResponse>>
}