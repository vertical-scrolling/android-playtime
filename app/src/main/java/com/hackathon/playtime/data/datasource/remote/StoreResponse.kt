package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

class StoreResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)