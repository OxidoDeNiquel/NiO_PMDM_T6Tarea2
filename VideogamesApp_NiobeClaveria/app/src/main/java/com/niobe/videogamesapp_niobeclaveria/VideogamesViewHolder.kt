package com.niobe.videogamesapp_niobeclaveria

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.niobe.videogamesapp_niobeclaveria.databinding.ItemVideogamesBinding
import com.squareup.picasso.Picasso

class VideogamesViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemVideogamesBinding.bind(view)
    fun bind(videogamesItemResponse: VideogamesItemResponse) {
        binding.tvVideogameName.text = videogamesItemResponse.name

        binding.tvVideogameRelease.text = videogamesItemResponse.releasedVG
        binding.tvVideogameRating.text = videogamesItemResponse.ratingVG

        // Mostrar las plataformas en el TextView
        val platforms = StringBuilder()

        // Verificar si la lista de plataformas no es nula antes de iterar
        if (videogamesItemResponse.platformsVG != null) {
            for (platformResponse in videogamesItemResponse.platformsVG) {
                val platformName = platformResponse.platformVG.platformName
                platforms.append(platformName).append("\n")
            }
        }

        binding.tvVideogamePlatforms.text = platforms.toString()
        Log.i("Plataformas", platforms.toString())

        Picasso.get().load(videogamesItemResponse.imageVG).into(binding.ivVideogame)
    }
}

