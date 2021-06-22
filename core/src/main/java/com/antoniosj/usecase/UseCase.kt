package com.antoniosj.usecase


data class UseCase<T>(val getCryptos: GetCryptos<T>)