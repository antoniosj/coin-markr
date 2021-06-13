package com.antoniosj.coinmarkr.data.datasource

import android.util.Log
import com.antoniosj.coinmarkr.data.api.CryptoService
import com.antoniosj.coinmarkr.data.mapper.toCryptoModel
import com.antoniosj.data.CryptoDataSource
import com.antoniosj.data.util.NetworkState
import com.antoniosj.model.Crypto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptoDataSourceImpl @Inject constructor(
    private val api: CryptoService,
) : CryptoDataSource<Crypto> {
    override fun getAllCrypto(): Flow<List<Crypto>> {
        return flow {
            val data = api.getAllCrypto().toCryptoModel()
            Log.d("ASJ", "ds impl $data")
            emit(data)
        }

    }
}