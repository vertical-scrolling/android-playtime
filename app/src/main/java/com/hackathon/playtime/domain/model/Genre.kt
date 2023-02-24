package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.GenreResponse

data class Genre(
    private val genreId: Int,
    private val genreName: String
)

fun GenreResponse.toEntity() = Genre(
    genreId = id,
    genreName = name
)