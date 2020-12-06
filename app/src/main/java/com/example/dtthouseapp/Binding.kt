package com.example.dtthouseapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load("https://intern.docker-dev.d-tt.nl"+ url)
        .into(view)
}