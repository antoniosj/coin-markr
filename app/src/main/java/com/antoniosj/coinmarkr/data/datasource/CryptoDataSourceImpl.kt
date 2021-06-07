package com.antoniosj.coinmarkr.data.datasource

import com.antoniosj.coinmarkr.data.api.CryptoService
import com.antoniosj.coinmarkr.data.mapper.toCrypto
import com.antoniosj.coinmarkr.data.model.CryptoResponse
import com.antoniosj.data.CryptoDataSource
import com.antoniosj.model.Crypto
import javax.inject.Inject

class CryptoDataSourceImpl @Inject constructor(
    private val api: CryptoService,
) : CryptoDataSource<Crypto> {
    override suspend fun getAll(): List<Crypto> {
        return api.getAllCrypto().toCrypto() // mapper
    }
}