package com.hackathon.playtime.domain.interactor.usecase

import com.hackathon.playtime.data.repository.GenreRepository
import com.hackathon.playtime.domain.model.Genre
import com.hackathon.playtime.domain.model.toEntity

interface GetGenresUseCase {
    suspend fun getGenres(): List<Genre>
}

class GetGenresUseCaseImpl(private val genreRepository: GenreRepository) : GetGenresUseCase {
    override suspend fun getGenres() =
        genreRepository.getGenres().map { genreResponse -> genreResponse.toEntity() }
}