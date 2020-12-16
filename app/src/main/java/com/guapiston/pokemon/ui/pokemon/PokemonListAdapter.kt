package com.guapiston.pokemon.ui.pokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.pokemon.R
import com.guapiston.pokemon.data.model.PokemonListResponse

class PokemonListAdapter : PagedListAdapter<PokemonListResponse.PokemonListItem,PokemonListAdapter.PokemonListViewHolder>(PokemonListResponse.PokemonListItem.DIFF_CALLBACK){

    class PokemonListViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvPokemonName = view.findViewById<TextView>(R.id.tv_pokemon_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        return PokemonListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_list,parent,false))
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.tvPokemonName.text = getItem(position)?.name
    }
}