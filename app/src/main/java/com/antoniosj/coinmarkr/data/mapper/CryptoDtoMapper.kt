package com.antoniosj.coinmarkr.data.mapper

import androidx.lifecycle.Transformations.map
import com.antoniosj.coinmarkr.data.model.CryptoResponse
import com.antoniosj.model.Crypto

fun List<CryptoResponse>.toCryptoModel() = map {
    Crypto(
        id = it.id,
        symbol = it.symbol,
        name = it.name,
        image = it.image,
        currentPrice = it.currentPrice,
        marketCapRank = it.marketCapRank,
        highDay = it.highDay,
        lowDay = it.lowDay,
        lastUpdated = it.lastUpdated,
    )
}