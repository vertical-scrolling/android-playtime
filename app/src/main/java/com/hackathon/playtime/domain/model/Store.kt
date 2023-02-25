package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.StoreResponse

data class Store(
    val storeId: Int,
    val storeName: String
)

fun StoreResponse.toEntity() = Store(
    storeId = id,
    storeName = name
)