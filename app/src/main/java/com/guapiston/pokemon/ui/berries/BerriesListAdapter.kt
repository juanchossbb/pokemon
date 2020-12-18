package com.guapiston.pokemon.ui.berries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.pokemon.R
import com.guapiston.pokemon.data.model.BerriesListResponse
import com.guapiston.pokemon.data.model.PokemonListResponse

class BerriesListAdapter(val listener : BerryClickListener) : PagedListAdapter<BerriesListResponse.Berry, BerriesListAdapter.BerrieslListViewHolder>(BerriesListResponse.Berry.DIFF_CALLBACK){


    class BerrieslListViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvBerryName = view.findViewById<TextView>(R.id.tv_berry_name)
        val btnFavorite = view.findViewById<ImageView>(R.id.iv_berry_favorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BerrieslListViewHolder {
        return BerrieslListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_berries_list,parent,false))
    }

    override fun onBindViewHolder(holder: BerrieslListViewHolder, position: Int) {
        val berry = getItem(position)
        berry?.let {
            holder.tvBerryName.text = it.name
            if(it.isFavorite){
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite)
            }

            holder.btnFavorite.setOnClickListener {view->
                it.isFavorite = !it.isFavorite
                notifyDataSetChanged()
                listener.onBerryClicked(it)
            }
        }
    }
}