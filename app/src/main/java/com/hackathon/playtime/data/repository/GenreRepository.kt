package com.hackathon.playtime.data.repository

interface GenreRepository {

    suspend fun getGenres(): List<String>

}