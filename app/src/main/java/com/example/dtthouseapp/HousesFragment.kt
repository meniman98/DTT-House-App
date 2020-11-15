package com.example.dtthouseapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HousesFragment : Fragment() {

    private lateinit var factory: HousesViewModelFactory
    private lateinit var viewModel: HousesViewModel
    private lateinit var rv : RecyclerView


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
        rv = view?.findViewById(R.id.rvHouses) ?: return

        //use the adapter
        viewModel.getHouses()
        viewModel.houses.observe(viewLifecycleOwner, Observer { houses ->
        rv.also {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter = HousesAdapter(houses, this)
        }
        })


    }


}