package com.hackathon.playtime.domain.interactor.usecase

import com.hackathon.playtime.data.repository.GameRepository
import com.hackathon.playtime.domain.model.GameSummary
import com.hackathon.playtime.domain.model.toEntity
import com.hackathon.playtime.utils.OrderByEnum

interface GetGamesUseCase {

    suspend operator fun invoke(
        filters: Map<String, String>,
        page: Int, pageSize: Int,
        order: OrderByEnum?
    ): List<GameSummary>

}

class GetGamesUseCaseImpl(private val gameRepository: GameRepository) : GetGamesUseCase {

    override suspend operator fun invoke(
        filters: Map<String, String>,
        page: Int, pageSize: Int,
        order: OrderByEnum?
    ): List<GameSummary> {
        val genreFilter = filters.getOrDefault("genre", "")
        val platformFilter = filters.getOrDefault("platform", "")
        val storeFilter = filters.getOrDefault("store", "")
        val ratingFilter = filters.getOrDefault("rating", "")
        return gameRepository.getGames(
            genreFilter,
            platformFilter,
            storeFilter,
            ratingFilter,
            page,
            pageSize,
            order).map { gameResponse -> gameResponse.toEntity() }
    }
}