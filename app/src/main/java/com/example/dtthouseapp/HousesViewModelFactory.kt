package com.example.dtthouseapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class HousesViewModelFactory(
    private val repo: HouseRepo
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HousesViewModel(repo) as T
    }

}