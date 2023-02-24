package com.hackathon.playtime.domain.model

import com.hackathon.playtime.data.datasource.remote.PlatformResponse

data class Platform(
    private val platformId: Int,
    private val platformName: String
)

fun PlatformResponse.toEntity() = Platform(
    platformId = id,
    platformName = name
)