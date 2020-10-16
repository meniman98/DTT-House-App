package com.example.dtthouseapp

data class HouseItem(
    val bathrooms: Int,
    val bedrooms: Int,
    val city: String,
    val createdDate: String,
    val description: String,
    val id: Int,
    val image: String,
    val latitude: Int,
    val longitude: Int,
    val price: Int,
    val size: Int,
    val zip: String
)