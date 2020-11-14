package com.example.dtthouseapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class HousesViewModel(
    private val repo: HouseRepo
) : ViewModel() {

    private lateinit var job: Job

    private val private_houses = MutableLiveData<List<HouseItem>>()
    val houses: LiveData<List<HouseItem>>
        // this get request returns the private houses which is
        // not exposed
        get() = private_houses

    fun getHouses() {
        job = Coroutines.ioMain(
            { repo.getHouses() },
            { private_houses.value = it }

        )


    }
    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }


}