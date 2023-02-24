package com.hackathon.playtime.data.repository

import com.hackathon.playtime.data.datasource.remote.PlatformResponse

interface PlatformRepository {

    suspend fun getPlatforms(): List<PlatformResponse>
}