package com.hackathon.playtime.domain.interactor

import com.hackathon.playtime.domain.interactor.usecase.GetGameDetailsUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetGameDetailsUseCaseImpl
import com.hackathon.playtime.domain.interactor.usecase.GetGamesUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetGamesUseCaseImpl
import com.hackathon.playtime.domain.interactor.usecase.GetGenresUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetGenresUseCaseImpl
import com.hackathon.playtime.domain.interactor.usecase.GetPlatformUseCaseImpl
import com.hackathon.playtime.domain.interactor.usecase.GetPlatformsUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetStoresUseCase
import com.hackathon.playtime.domain.interactor.usecase.GetStoresUseCaseImpl
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

val useCasesModule = module {
    single { GetGenresUseCaseImpl(get()) } bind GetGenresUseCase::class
    single { GetPlatformUseCaseImpl(get()) } bind GetPlatformsUseCase::class
    single { GetStoresUseCaseImpl(get()) } bind GetStoresUseCase::class
    single { GetGameDetailsUseCaseImpl(get()) } bind GetGameDetailsUseCase::class
    single { GetGamesUseCaseImpl(get()) } bind GetGamesUseCase::class
}