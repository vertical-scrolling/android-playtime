package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

class StoreResponse (
    @SerializedName("id") val storeId: Int,
    @SerializedName("name") val toreName: String
)