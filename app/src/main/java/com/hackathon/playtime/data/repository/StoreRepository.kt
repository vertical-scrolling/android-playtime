package com.hackathon.playtime.data.repository

import com.hackathon.playtime.data.datasource.remote.StoreResponse

interface StoreRepository {

    suspend fun getStores(): List<StoreResponse>

}