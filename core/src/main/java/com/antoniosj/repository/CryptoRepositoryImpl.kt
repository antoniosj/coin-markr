package com.antoniosj.repository

import com.antoniosj.data.CryptoDataSource
import com.antoniosj.data.util.NetworkState
import com.antoniosj.data.util.networkBoundResource
import com.antoniosj.model.Crypto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(val api: CryptoDataSource<Crypto>) :
    CryptoRepository<Crypto> {

    override fun getAllCrypto(): Flow<List<Crypto>> {
        return api.getAllCrypto()
    }


}