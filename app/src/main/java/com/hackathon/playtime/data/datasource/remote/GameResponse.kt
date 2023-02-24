package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class GameResponse ( //TODO: Api definition
    @SerializedName("id") val gameId: Int
)

