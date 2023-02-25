package com.hackathon.playtime

import android.app.Application
import com.hackathon.playtime.di.apiModule
import com.hackathon.playtime.di.networkModule
import com.hackathon.playtime.domain.interactor.repositoriesModule
import com.hackathon.playtime.domain.interactor.useCasesModule
import com.hackathon.playtime.ui.viewmodel.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.startKoin

class PlayTimeApp : Application() {

    @KoinExperimentalAPI
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PlayTimeApp)
            modules(
                listOf(
                    networkModule,
                    apiModule,
                    viewModelsModule,
                    useCasesModule,
                    repositoriesModule
                )
            )
        }
    }

}