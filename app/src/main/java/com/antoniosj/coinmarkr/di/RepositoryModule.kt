package com.antoniosj.coinmarkr.di

import com.antoniosj.data.CryptoDataSource
import com.antoniosj.model.Crypto
import com.antoniosj.repository.CryptoRepository
import com.antoniosj.repository.CryptoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCryptoRepository(api: CryptoDataSource<Crypto>): CryptoRepository<Crypto> {
        return CryptoRepositoryImpl(api)
    }
}