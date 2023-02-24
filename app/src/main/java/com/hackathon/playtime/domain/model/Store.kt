package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.StoreResponse

data class Store(
    private val storeId: Int,
    private val storeName: String
)

fun StoreResponse.toEntity() = Store(
    storeId = id,
    storeName = name
)