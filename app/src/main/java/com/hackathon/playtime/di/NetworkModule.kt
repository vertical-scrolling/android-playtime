package com.hackathon.playtime.di

import com.hackathon.playtime.BuildConfig
import com.hackathon.playtime.data.datasource.api.GameApi
import com.hackathon.playtime.data.datasource.api.GenreApi
import com.hackathon.playtime.data.datasource.api.PlatformApi
import com.hackathon.playtime.data.datasource.api.StoreApi
import com.hackathon.playtime.domain.model.Store
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    single(named("client")) { provideRetrofit(get()) }
}

val apiModule = module {
    single { get<Retrofit>(named("client")).create(GameApi::class.java) }
    single { get<Retrofit>(named("client")).create(StoreApi::class.java) }
    single { get<Retrofit>(named("client")).create(PlatformApi::class.java) }
    single { get<Retrofit>(named("client")).create(GenreApi::class.java) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()
}

fun provideOkHttpClient() = OkHttpClient.Builder().apply {
    if (BuildConfig.DEBUG) {
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }
}.build()