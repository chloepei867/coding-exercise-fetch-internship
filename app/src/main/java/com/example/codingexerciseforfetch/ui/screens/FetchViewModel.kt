package com.example.codingexerciseforfetch.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingexerciseforfetch.data.NetworkFetchItemRepository
import com.example.codingexerciseforfetch.model.FetchItem
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface FetchUiState {
    data class Success(val items: List<FetchItem>) : FetchUiState
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
//                val finalResult = listResult
//                    //filter out null or blank names
//                    .filter{!it.name.isNullOrBlank()}
//                    //sort by listId and name
//                    .sortedWith(compareBy({it.listId}, {it.name}))
//                    .groupBy { it.listId }
                fetchUiState = FetchUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                FetchUiState.Error
            }
        }
    }
}