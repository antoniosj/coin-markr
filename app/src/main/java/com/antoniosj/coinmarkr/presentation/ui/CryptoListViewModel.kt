package com.antoniosj.coinmarkr.presentation.ui


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniosj.coinmarkr.data.api.CryptoService
import com.antoniosj.coinmarkr.data.model.CryptoResponse
import com.antoniosj.data.CryptoDataSource
import com.antoniosj.model.Crypto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    val ds: CryptoDataSource<Crypto>
): ViewModel() {

    fun temp() {
        viewModelScope.launch {
            Log.d("ASJ", ds.getAll().toString())
        }
    }
}