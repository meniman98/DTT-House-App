package com.example.dtthouseapp

class HouseRepo(
    private val api: HouseApi
) : ApiRequest() {

    suspend fun getHouses() = apiRequest { api.getHouses() }
}

