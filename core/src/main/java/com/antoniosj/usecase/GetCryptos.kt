package com.antoniosj.usecase

import com.antoniosj.model.Crypto
import com.antoniosj.repository.CryptoRepository
import javax.inject.Inject
import javax.inject.Qualifier

class GetCryptos<T> @Inject constructor(private val repository: CryptoRepository<T>) {
    operator fun invoke() = repository.getAllCrypto()
}