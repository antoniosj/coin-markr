package com.antoniosj.coinmarkr.di

import com.antoniosj.coinmarkr.data.api.CryptoService
import com.antoniosj.coinmarkr.data.datasource.CryptoDataSourceImpl
import com.antoniosj.coinmarkr.data.model.CryptoResponse
import com.antoniosj.data.CryptoDataSource
import com.antoniosj.model.Crypto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideCryptoDataSource(api: CryptoService): CryptoDataSource<Crypto> {
        return CryptoDataSourceImpl(api)
    }

}