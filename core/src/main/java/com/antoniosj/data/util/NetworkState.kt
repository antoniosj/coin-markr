package com.antoniosj.data.util

sealed class NetworkState<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : NetworkState<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : NetworkState<T>(data, throwable)
    class Loading<T>(data: T? = null): NetworkState<T>(data)
}