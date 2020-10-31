package com.example.dtthouseapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

class HousesFragment : Fragment() {

    private lateinit var factory: HousesViewModelFactory
    private lateinit var viewModel: HousesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.houses_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = HouseApi()
        val repo = HouseRepo(api)
        factory = HousesViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this).get(HousesViewModel::class.java)


    }


}