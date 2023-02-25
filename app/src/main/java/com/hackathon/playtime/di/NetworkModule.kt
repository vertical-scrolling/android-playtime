package com.hackathon.playtime.di

import com.hackathon.playtime.BuildConfig
import com.hackathon.playtime.data.datasource.api.GameApi
import com.hackathon.playtime.data.datasource.api.GenreApi
import com.hackathon.playtime.data.datasource.api.PlatformApi
import com.hackathon.playtime.data.datasource.api.StoreApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideGameApi(get()) }
    factory { provideGenreApi(get()) }
    factory { provideStoreApi(get()) }
    factory { providePlatformApi(get()) }
    single { provideRetrofit(get()) }
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

fun provideGameApi(retrofit: Retrofit): GameApi = retrofit.create(GameApi::class.java)
fun provideStoreApi(retrofit: Retrofit): StoreApi = retrofit.create(StoreApi::class.java)
fun providePlatformApi(retrofit: Retrofit): PlatformApi = retrofit.create(PlatformApi::class.java)
fun provideGenreApi(retrofit: Retrofit): GenreApi = retrofit.create(GenreApi::class.java)