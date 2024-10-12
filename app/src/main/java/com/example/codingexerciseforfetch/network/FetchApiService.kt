package com.example.codingexerciseforfetch.network


import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface FetchApiService{
    @GET("hiring.json")
    suspend fun getItems(): String
}

object FetchApi {
    val retrofitService: FetchApiService by lazy {
        retrofit.create(FetchApiService::class.java)
    }
}