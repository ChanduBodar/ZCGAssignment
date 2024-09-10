package com.zcgapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zcgapplication.api.APIInstance
import com.zcgapplication.model.ItemType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BlockViewModel : ViewModel() {
    private val apiService = APIInstance.api
    val blocks: MutableStateFlow<ArrayList<ItemType>> = MutableStateFlow(ArrayList())
    fun getBlocks() {
        viewModelScope.launch {
            try {
                val response = apiService.getBlocks()
                if (response.isNotEmpty()) {
                    blocks.value = response
                }
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }
}