package com.hackathon.playtime.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class GenreObjectResponse(
    @SerializedName("genres") val genres: List<GenreResponse>
)

data class GenreResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)