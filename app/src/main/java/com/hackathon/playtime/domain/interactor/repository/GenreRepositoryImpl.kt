package com.hackathon.playtime.domain.interactor.repository

import android.util.Log
import com.hackathon.playtime.data.datasource.api.GenreApi
import com.hackathon.playtime.data.datasource.remote.GenreResponse
import com.hackathon.playtime.data.repository.GenreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GenreRepositoryImpl(private val genreApi: GenreApi) : GenreRepository {

    companion object {
        private const val DEFAULT_PAGE = 1
        private const val DEFAULT_PAGE_SIZE = 25
        private const val DEFAULT_ORDER = "games_count"
    }

    override suspend fun getGenres(): List<GenreResponse> =
        withContext(Dispatchers.IO) {
            try{
                val genresResponse = genreApi.getGenres(DEFAULT_PAGE, DEFAULT_PAGE_SIZE, DEFAULT_ORDER)
                genresResponse.body()?.genres ?: emptyList()
            } catch (e: Exception) {
                Log.e("GenreRepo", "getGenres error: $e")
                emptyList()
            }
        }
}