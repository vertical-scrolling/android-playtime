package com.hackathon.playtime.data.repository

import com.hackathon.playtime.data.datasource.remote.GenreResponse

interface GenreRepository {

    suspend fun getGenres(): List<GenreResponse>

}