package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.PlatformResponse

data class Platform(
    val platformId: Int,
    val platformName: String
)

fun PlatformResponse.toEntity() = Platform(
    platformId = id,
    platformName = name
)