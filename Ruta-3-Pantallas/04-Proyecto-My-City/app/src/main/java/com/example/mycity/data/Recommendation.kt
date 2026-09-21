package com.example.mycity.data

data class Recommendation(
    val id: Int,
    val name: String,
    val category: Category,
    val shortDescription: String,
    val longDescription: String,
    val address: String,
    val openingHours: String
)
