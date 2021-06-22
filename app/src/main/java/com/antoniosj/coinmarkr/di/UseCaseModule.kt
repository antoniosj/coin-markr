package com.antoniosj.coinmarkr.di

import com.antoniosj.model.Crypto
import com.antoniosj.repository.CryptoRepository
import com.antoniosj.usecase.GetCryptos
import com.antoniosj.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun providesUseCase(uc: GetCryptos<Crypto>): UseCase<Crypto> {
         return UseCase(uc)
    }
}