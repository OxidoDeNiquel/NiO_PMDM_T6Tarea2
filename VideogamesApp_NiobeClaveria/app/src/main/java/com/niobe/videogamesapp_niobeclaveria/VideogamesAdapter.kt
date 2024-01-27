package com.niobe.videogamesapp_niobeclaveria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VideogamesAdapter (var videogamesList: List<VideogamesItemResponse> =
                             emptyList()): RecyclerView.Adapter<VideogamesViewHolder>() {

    fun updateList(list: List<VideogamesItemResponse>) {
        videogamesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideogamesViewHolder {
        return VideogamesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_videogames, parent, false)
        )
    }
    override fun onBindViewHolder(holder: VideogamesViewHolder, position: Int) {
        holder.bind(videogamesList[position])
    }
    override fun getItemCount() = videogamesList.size

}