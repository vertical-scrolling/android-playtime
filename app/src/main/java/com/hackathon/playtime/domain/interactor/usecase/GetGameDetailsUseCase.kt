package com.hackathon.playtime.domain.interactor.usecase

import com.hackathon.playtime.data.repository.GameRepository
import com.hackathon.playtime.domain.model.GameDetails
import com.hackathon.playtime.domain.model.toEntity

interface GetGameDetailsUseCase {

    suspend fun invoke(gameId: Int): GameDetails
}


class GetGameDetailsUseCaseImpl(private val gameRepository: GameRepository): GetGameDetailsUseCase {

        override suspend fun invoke(gameId: Int): GameDetails {
            return gameRepository.getGameDetails(gameId).toEntity()
        }
}