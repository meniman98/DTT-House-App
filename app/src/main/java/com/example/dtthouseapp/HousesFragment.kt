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
    private lateinit var rv: RecyclerView
    private lateinit var adapter: HousesAdapter


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
        viewModel = ViewModelProviders.of(this, factory).get(HousesViewModel::class.java)
        rv = view?.findViewById(R.id.rvHouses)!!
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.setHasFixedSize(true)
        //use the adapter

        viewModel.houses.observe(viewLifecycleOwner, Observer { houses ->
            rv.also {
            rv.adapter = HousesAdapter(houses, this)




            }
        })
        viewModel.getHouses()


    }


}