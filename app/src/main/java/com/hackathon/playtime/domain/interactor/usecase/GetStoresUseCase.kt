package com.hackathon.playtime.domain.interactor.usecase

import com.hackathon.playtime.data.repository.StoreRepository
import com.hackathon.playtime.domain.model.Store
import com.hackathon.playtime.domain.model.toEntity

interface GetStoresUseCase {
    suspend operator fun invoke(): List<Store>
}

class GetStoresUseCaseImpl(private val storeRepository: StoreRepository) : GetStoresUseCase {
    override suspend operator fun invoke() =
        storeRepository.getStores().map { storeResponse -> storeResponse.toEntity() }
}