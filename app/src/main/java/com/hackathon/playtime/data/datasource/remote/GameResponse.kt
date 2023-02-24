package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class GameResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("released") val releaseDate: String?,
    @SerializedName("rating") val rating: Double,
    @SerializedName("media") val media: GameMedia?,
)

data class GameMedia(
    @SerializedName("url") val url: String,
)

