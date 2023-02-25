package com.hackathon.playtime.domain.interactor.usecase

import com.hackathon.playtime.data.repository.PlatformRepository
import com.hackathon.playtime.domain.model.Platform
import com.hackathon.playtime.domain.model.toEntity

interface GetPlatformsUseCase {
    suspend operator fun invoke(): List<Platform>
}

class GetPlatformUseCaseImpl(private val platformRepository: PlatformRepository) : GetPlatformsUseCase {
    override suspend operator fun invoke() =
        platformRepository.getPlatforms().map { platformResponse -> platformResponse.toEntity() }
}