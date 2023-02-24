package com.hackathon.playtime.domain.interactor

import com.hackathon.playtime.data.repository.GameRepository
import com.hackathon.playtime.data.repository.GenreRepository
import com.hackathon.playtime.data.repository.PlatformRepository
import com.hackathon.playtime.data.repository.StoreRepository
import com.hackathon.playtime.domain.interactor.repository.GameRepositoryImpl
import com.hackathon.playtime.domain.interactor.repository.GenreRepositoryImpl
import com.hackathon.playtime.domain.interactor.repository.PlatformRepositoryImpl
import com.hackathon.playtime.domain.interactor.repository.StoreRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoriesModule = module {
    single { GameRepositoryImpl(get()) } bind GameRepository::class
    single { PlatformRepositoryImpl(get()) } bind PlatformRepository::class
    single { GenreRepositoryImpl(get()) } bind GenreRepository::class
    single { StoreRepositoryImpl(get()) } bind StoreRepository::class
}