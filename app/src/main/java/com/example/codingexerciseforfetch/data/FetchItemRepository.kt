package com.example.codingexerciseforfetch.data

import com.example.codingexerciseforfetch.network.FetchApi
import com.example.codingexerciseforfetch.network.FetchItem

interface FetchItemRepository {
    suspend fun getFetchItems(): List<FetchItem>
}

class NetworkFetchItemRepository() : FetchItemRepository {
    override suspend fun getFetchItems(): List<FetchItem> {
        return FetchApi.retrofitService.getItems()
    }
}