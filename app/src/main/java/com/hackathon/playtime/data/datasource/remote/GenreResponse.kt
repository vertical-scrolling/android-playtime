package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class GenreResponse (
    @SerializedName("id") val genreId: Int,
    @SerializedName("name") val genreName: String
)