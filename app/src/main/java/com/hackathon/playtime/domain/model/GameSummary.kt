package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.GameResponse

data class GameSummary(
    val gameId: Int,
    val gameName: String,
    val gameReleaseDate: String?,
    val gameRating: Double,
    val imageUrl: String?
)

fun GameResponse.toEntity() = GameSummary(
    gameId = id,
    gameName = name,
    gameReleaseDate = releaseDate,
    gameRating = rating,
    imageUrl = media?.url
)