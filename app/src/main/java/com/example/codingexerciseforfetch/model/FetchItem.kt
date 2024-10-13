package com.example.codingexerciseforfetch.model

import kotlinx.serialization.Serializable

@Serializable
data class FetchItem(
    val id: Int,
    val listId: Int,
    val name: String?
)



///**
// * This data class defines a Mars photo which includes an ID, and the image URL.
// */
//@Serializable
//data class FetchItem(
//    val id: String,
//    @SerialName(value = "img_src")
//    val imgSrc: String
//)