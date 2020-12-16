package com.guapiston.pokemon.ui.pokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.pokemon.R
import com.guapiston.pokemon.data.model.PokemonDetailResponse

class PokemonSkillsAdapter(val list : List<PokemonDetailResponse.Ability>) : RecyclerView.Adapter<PokemonSkillsAdapter.PokemonSkillsViewHolder>(){


    class PokemonSkillsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvSkillName = view.findViewById<TextView>(R.id.tv_description_skill_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonSkillsViewHolder {
        return PokemonSkillsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_description_skill,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PokemonSkillsViewHolder, position: Int) {
        val ability = list[position]
        holder.tvSkillName.text = ability.ability.name
    }
}