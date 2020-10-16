package com.example.dtthouseapp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface HouseApi {
    @Headers("access-key: 98bww4ezuzfePCYFxJEWyszbUXc7dxRx")
    @GET("house")
    suspend fun getHouses() : Response<List<HouseItem>>



    companion object {
        operator fun invoke(): HouseApi {
           return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://intern.docker-dev.d-tt.nl/api/")
                .build()
                .create(HouseApi::class.java)
        }
    }
}