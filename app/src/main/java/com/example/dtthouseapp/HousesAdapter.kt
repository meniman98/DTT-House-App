package com.example.dtthouseapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dtthouseapp.databinding.RecyclerviewHouseBinding


class HousesAdapter(
    private val houses: List<HouseItem>
) : RecyclerView.Adapter<HousesAdapter.HousesViewHolder>() {

    override fun getItemCount() = houses.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HousesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_house,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HousesViewHolder, position: Int) {
        holder.recyclerviewHouseBinding.house = houses[position]
    }

    inner class HousesViewHolder(

        val recyclerviewHouseBinding: RecyclerviewHouseBinding

    ) : RecyclerView.ViewHolder(recyclerviewHouseBinding.root)
}