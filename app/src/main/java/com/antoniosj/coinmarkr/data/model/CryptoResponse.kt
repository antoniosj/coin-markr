package com.antoniosj.coinmarkr.data.model

import com.google.gson.annotations.SerializedName

data class CryptoResponse (
    @SerializedName("id") val id: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("current_price") val currentPrice: Double,
    @SerializedName("market_cap_rank") val marketCapRank: Int,
    @SerializedName("high_24h") val highDay: Double,
    @SerializedName("low_24h") val lowDay: Double,
    @SerializedName("last_updated") val lastUpdated: String,
)
