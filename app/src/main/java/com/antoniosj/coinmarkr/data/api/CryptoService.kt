package com.antoniosj.coinmarkr.data.api

import com.antoniosj.coinmarkr.data.model.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoService {

    @GET("coins/markets?vs_currency=brl&order=market_cap_desc&per_page=20&sparkline=true")
    suspend fun getAllCrypto(@Query("page") page: Int = 1): List<CryptoResponse>
}