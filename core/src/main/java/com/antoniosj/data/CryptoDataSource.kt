package com.antoniosj.data

import com.antoniosj.data.util.NetworkState
import kotlinx.coroutines.flow.Flow

interface CryptoDataSource<T> {
    fun getAllCrypto(): Flow<List<T>>
}