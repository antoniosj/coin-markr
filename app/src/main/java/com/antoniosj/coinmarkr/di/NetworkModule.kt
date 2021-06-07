package com.antoniosj.coinmarkr.di

import com.antoniosj.coinmarkr.data.api.CryptoService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val timeOut = 20L


    @Singleton
    @Provides
    fun provideCryptoService(): CryptoService {

        val okHttpClient by lazy {
            OkHttpClient.Builder().apply {
                readTimeout(timeOut, TimeUnit.SECONDS)
                connectTimeout(timeOut, TimeUnit.SECONDS)
            }.build()
        }

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CryptoService::class.java)
    }

}