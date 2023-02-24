package com.hackathon.playtime.domain.interactor.usecase

import com.hackathon.playtime.data.repository.PlatformRepository
import com.hackathon.playtime.domain.model.Platform
import com.hackathon.playtime.domain.model.toEntity

interface GetPlatformsUseCase {
    suspend fun getPlatforms(): List<Platform>
}

class GetPlatformUseCaseImpl(private val platformRepository: PlatformRepository) : GetPlatformsUseCase {
    override suspend fun getPlatforms() =
        platformRepository.getPlatforms().map { platformResponse -> platformResponse.toEntity() }
}