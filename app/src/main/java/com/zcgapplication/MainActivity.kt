package com.zcgapplication

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.zcgapplication.receiver.NetworkReceiver
import com.zcgapplication.ui.theme.ZCGApplicationTheme
import com.zcgapplication.ui.views.ItemTypeList
import com.zcgapplication.ui.views.NoInternetRetry
import com.zcgapplication.viewmodel.BlockViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: BlockViewModel by viewModels()
    private var networkReceiver: NetworkReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZCGApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ItemTypeList(viewModel = viewModel)
                }
            }
        }
        setupNetworkListener()
    }

    private fun setupNetworkListener() {
        NetworkReceiver.networkReceiverListener = object : NetworkReceiver.NetworkReceiverListener {
            override fun onNetworkConnectionChanged(isConnected: Boolean) {
                //toggleNoInternetBar(!isConnected)
            }
        }
    }

    @Composable
    private fun toggleNoInternetBar(display: Boolean) {
        if (display) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NoInternetRetry()
            }
        } else {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ItemTypeList(viewModel = viewModel)
            }
        }
    }


    override fun onStart() {
        super.onStart()
        try {
            networkReceiver = NetworkReceiver()
            ContextCompat.registerReceiver(
                this,
                networkReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION),
                ContextCompat.RECEIVER_NOT_EXPORTED
            )
        } catch (e: Exception) {

        }
    }

    override fun onStop() {
        super.onStop()
        try {
            networkReceiver?.let { unregisterReceiver(it) }
        } catch (e: Exception) {

        }
    }
}