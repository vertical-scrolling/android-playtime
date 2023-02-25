package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class StoreObjectResponse(
    @SerializedName("stores") val stores: List<StoreResponse>
)

class StoreResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)