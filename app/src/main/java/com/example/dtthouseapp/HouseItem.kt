package com.example.dtthouseapp

data class HouseItem(
    var url: String = "https://intern.docker-dev.d-tt.nl/",
    val bathrooms: String,
    val bedrooms: String,
    val city: String,
    val createdDate: String,
    val description: String,
    val id: String,
    val image: String,
    val latitude: String,
    val longitude: String,
    val price: String,
    val size: String,
    val zip: String
)