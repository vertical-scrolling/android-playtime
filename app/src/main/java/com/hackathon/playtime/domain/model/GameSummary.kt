package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.GameResponse

data class GameSummary(
    private val gameId: Int,
    private val gameName: String,
    private val gameReleaseDate: String?,
    private val gameRating: Double,
    private val imageUrl: String?
    ) {
}

fun GameResponse.toEntity() = GameSummary(
    gameId = id,
    gameName = name,
    gameReleaseDate = releaseDate,
    gameRating = rating,
    imageUrl = media?.url
)