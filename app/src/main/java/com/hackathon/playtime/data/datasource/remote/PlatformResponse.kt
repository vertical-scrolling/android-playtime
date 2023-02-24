package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class PlatformResponse (
    @SerializedName("id") val platformId: Int,
    @SerializedName("name") val platformName: String
)