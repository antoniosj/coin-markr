package com.antoniosj.model

data class Crypto(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
    val marketCapRank: Int,
    val highDay: Double,
    val lowDay: Double,
    val lastUpdated: String,
)