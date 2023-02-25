package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.GameDetailsResponse

data class GameDetails(
    val gameId: Int,
    val gameName: String,
    val gameReleaseDate: String?,
    val gameRating: Double,
    val imageUrl: String?,
    val gameSynopsis: String,
    val gamePlaytime: Int,
    val gameStatus: String
)

fun GameDetailsResponse.toEntity() = GameDetails(
        gameId = id,
        gameName = name,
        gameReleaseDate = released,
        gameRating = rating,
        imageUrl = media?.url,
        gameSynopsis = description,
        gamePlaytime = playtime,
        gameStatus = status
)