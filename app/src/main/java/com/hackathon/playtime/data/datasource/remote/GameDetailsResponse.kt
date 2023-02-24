package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class GameDetailsResponse (
    @SerializedName("id") val gameId: Int
)