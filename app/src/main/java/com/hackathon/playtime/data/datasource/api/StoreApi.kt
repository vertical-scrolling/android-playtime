package com.hackathon.playtime.data.datasource.api

import com.hackathon.playtime.data.datasource.remote.StoreResponse
import retrofit2.Response
import retrofit2.http.GET

interface StoreApi {

    @GET("/1/stores")
    suspend fun getStores(): Response<List<StoreResponse>>
}