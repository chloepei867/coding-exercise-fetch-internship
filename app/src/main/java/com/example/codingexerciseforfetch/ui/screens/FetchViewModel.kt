package com.example.codingexerciseforfetch.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingexerciseforfetch.data.NetworkFetchItemRepository
import com.example.codingexerciseforfetch.network.FetchApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface FetchUiState {
    data class Success(val items: String) : FetchUiState
    object Error : FetchUiState
    object Loading : FetchUiState
}

class FetchViewModel: ViewModel() {
    var fetchUiState: FetchUiState by mutableStateOf(FetchUiState.Loading)
        private set

    init{
        getFetchItems()
    }

    private fun getFetchItems() {
        viewModelScope.launch{
            try {
                val fetchItemRepository = NetworkFetchItemRepository()
                val listResult = fetchItemRepository.getFetchItems()
                fetchUiState = FetchUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
                )
            } catch (e: IOException) {
                FetchUiState.Error
            }
        }
    }
}