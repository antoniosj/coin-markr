package com.antoniosj.data.util

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline get: suspend () -> RequestType,
    crossinline saveFetchedResult: suspend (RequestType) -> Unit,
    crossinline shouldFetchFromApi: (ResultType) -> Boolean = { true }
) = flow {

    val data = query().first()

    val flow = if (shouldFetchFromApi(data)) {
        emit(NetworkState.Loading(data))

        try {
            saveFetchedResult(get())
            query().map { NetworkState.Success(it) }
        } catch (throwable: Throwable) {
            query().map { NetworkState.Error(throwable, it) } // it = resulttype (data)
        }
    } else {
        query().map { NetworkState.Success(it) }
    }

    emitAll(flow)
}
