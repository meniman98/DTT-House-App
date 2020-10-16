package com.example.dtthouseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = HouseRepo(HouseApi())

        GlobalScope.launch(Dispatchers.Main) {
            val houses = repo.getHouses()
            Toast.makeText(this@MainActivity, houses.toString(), Toast.LENGTH_LONG).show()
            Log.i("main", houses.toString())
        }



    }

}