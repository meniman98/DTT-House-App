package com.example.dtthouseapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HousesViewModel(
    private val repo: HouseRepo
) : ViewModel() {

    private val private_houses = MutableLiveData<List<HouseItem>>()
    val houses : LiveData<List<HouseItem>>
        // this get request returns the private houses which is
        // not exposed
    get() = private_houses

    suspend fun getHouses() {
        val houses = repo.getHouses()
        private_houses.value = houses
    }
}