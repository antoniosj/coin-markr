package com.antoniosj.coinmarkr.presentation.ui


import android.util.Log
import androidx.lifecycle.*
import com.antoniosj.data.CryptoDataSource
import com.antoniosj.data.util.NetworkState
import com.antoniosj.model.Crypto
import com.antoniosj.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    val repository: CryptoRepository<Crypto>
) : ViewModel() {

    var cryptoList = MutableLiveData<List<Crypto>>()

    var result = repository.getAllCrypto().asLiveData()

    fun temp(): LiveData<List<Crypto>> {
        viewModelScope.launch {
            repository.getAllCrypto().collect {
                cryptoList.value = it
            }
          //  Log.d("ASJ", "vw2" + result.value.toString())
        }
        return cryptoList
    }
}