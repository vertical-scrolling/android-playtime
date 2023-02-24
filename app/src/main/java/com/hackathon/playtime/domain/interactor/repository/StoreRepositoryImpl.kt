package com.hackathon.playtime.domain.interactor.repository

import com.hackathon.playtime.data.datasource.api.StoreApi
import com.hackathon.playtime.data.datasource.remote.StoreResponse
import com.hackathon.playtime.data.repository.StoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StoreRepositoryImpl(private val storeApi: StoreApi) : StoreRepository {

    companion object {
        private const val DEFAULT_PAGE = 1
        private const val DEFAULT_PAGE_SIZE = 25
        private const val DEFAULT_ORDER = "games_count"
    }

    override suspend fun getStores(): List<StoreResponse> =
        withContext(Dispatchers.IO) {
            try {
                val storesResponse = storeApi.getStores(DEFAULT_PAGE, DEFAULT_PAGE_SIZE, DEFAULT_ORDER)
                storesResponse.body() ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
}