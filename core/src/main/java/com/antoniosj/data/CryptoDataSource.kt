package com.antoniosj.data

interface CryptoDataSource<T> {
    suspend fun getAll(): List<T>
}