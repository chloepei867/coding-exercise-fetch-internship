package com.example.codingexerciseforfetch.network


import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


private const val BASE_URL =
    "https://fetch-hiring.s3.amazonaws.com"
//"https://android-kotlin-fun-mars-server.appspot.com"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface FetchApiService{
    @GET("hiring.json")
//      @GET("photos")
    suspend fun getItems(): List<FetchItem>
}

object FetchApi {
    val retrofitService: FetchApiService by lazy {
        retrofit.create(FetchApiService::class.java)
    }
}