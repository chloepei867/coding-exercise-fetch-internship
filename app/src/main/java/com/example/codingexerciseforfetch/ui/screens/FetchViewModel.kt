package com.example.codingexerciseforfetch.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingexerciseforfetch.network.FetchApi
import kotlinx.coroutines.launch

class FetchViewModel: ViewModel() {
    var fetchUiState: String by mutableStateOf("")
        private set

    init{
        getFetchItems()
    }

    private fun getFetchItems() {
        viewModelScope.launch{
            val listResult = FetchApi.retrofitService.getItems()
            fetchUiState = listResult
        }
    }
}