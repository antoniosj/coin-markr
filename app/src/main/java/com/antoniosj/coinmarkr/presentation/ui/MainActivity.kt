package com.antoniosj.coinmarkr.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.antoniosj.coinmarkr.data.api.CryptoService
import com.antoniosj.coinmarkr.presentation.components.CryptoList
import com.antoniosj.coinmarkr.presentation.theme.CoinMarkrTheme
import com.antoniosj.model.Crypto
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val viewModel: CryptoListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val list by viewModel.result.observeAsState(initial = emptyList())

            CoinMarkrTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    if (list.isNotEmpty()) {
                        Cryptos(cryptos = list)
                    }
                }
            }
        }
    }


}

@Suppress("FunctionNaming")
@Composable
fun Cryptos(cryptos: List<Crypto>) {
    LazyColumn {
        items(cryptos) { crypto ->
            CryptoList(crypto) {
                // Implement click later
            }
        }
    }
}