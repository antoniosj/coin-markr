package com.antoniosj.coinmarkr.presentation.ui


import android.util.Log
import androidx.lifecycle.*
import com.antoniosj.data.CryptoDataSource
import com.antoniosj.data.util.NetworkState
import com.antoniosj.model.Crypto
import com.antoniosj.repository.CryptoRepository
import com.antoniosj.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    val useCase: UseCase<Crypto>
) : ViewModel() {

      val result = useCase.getCryptos.invoke().asLiveData()
//
//    var result = repository.getAllCrypto().asLiveData()
//    var result2 = repository.getAllCrypto().asLiveData().map { NetworkState.Success(it) }

}
