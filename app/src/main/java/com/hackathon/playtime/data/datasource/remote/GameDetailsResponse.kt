package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class GameDetailsResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("released") val released: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("media") val media: GameMedia,
    @SerializedName("description") val description: String,
    @SerializedName("playtime") val playtime: Int,
    @SerializedName("status") val status: String,
)