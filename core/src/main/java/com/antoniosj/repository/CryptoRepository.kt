package com.antoniosj.repository

import com.antoniosj.data.util.NetworkState
import kotlinx.coroutines.flow.Flow

interface CryptoRepository<T> {
    fun getAllCrypto(): Flow<List<T>>
}