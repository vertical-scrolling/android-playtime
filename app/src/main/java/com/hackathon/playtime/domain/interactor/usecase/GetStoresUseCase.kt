package com.hackathon.playtime.domain.interactor.usecase

import com.hackathon.playtime.data.repository.StoreRepository
import com.hackathon.playtime.domain.model.Store
import com.hackathon.playtime.domain.model.toEntity

interface GetStoresUseCase {
    suspend fun getStores(): List<Store>
}

class GetStoresUseCaseImpl(private val storeRepository: StoreRepository) : GetStoresUseCase {
    override suspend fun getStores() =
        storeRepository.getStores().map { storeResponse -> storeResponse.toEntity() }
}