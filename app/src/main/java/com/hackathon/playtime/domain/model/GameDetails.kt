package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.GameDetailsResponse

data class GameDetails(
    private val gameId: Int,
    private val gameName: String
)

fun GameDetailsResponse.toEntity() = GameDetails(
    gameId = id,
    gameName = name
)