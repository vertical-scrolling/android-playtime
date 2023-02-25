package com.hackathon.playtime.domain.interactor.repository

import android.util.Log
import com.hackathon.playtime.data.datasource.api.PlatformApi
import com.hackathon.playtime.data.datasource.remote.PlatformResponse
import com.hackathon.playtime.data.repository.PlatformRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlatformRepositoryImpl(private val platformApi: PlatformApi) : PlatformRepository {

    companion object {
        private const val DEFAULT_PAGE = 1
        private const val DEFAULT_PAGE_SIZE = 25
        private const val DEFAULT_ORDER = "games_count"
    }

    override suspend fun getPlatforms(): List<PlatformResponse> =
        withContext(Dispatchers.IO) {
            try {
                val platformsResponse = platformApi.getPlatforms(DEFAULT_PAGE, DEFAULT_PAGE_SIZE, DEFAULT_ORDER)
                platformsResponse.body() ?: emptyList()
            } catch (e: Exception) {
                Log.e("PlatformRepo", "getPlatforms error: $e")
                emptyList()
            }
        }
}