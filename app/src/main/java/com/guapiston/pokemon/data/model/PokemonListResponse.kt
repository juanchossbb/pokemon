package com.guapiston.pokemon.data.model

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

class PokemonListResponse {
    var count = 0
    var next : String? = null
    var previous : String? = null
    lateinit var results : List<PokemonListItem>

    @Entity(tableName = "pokemon")
    class PokemonListItem{
        @PrimaryKey(autoGenerate = true)
        var id : Int = 0
        lateinit var name : String
        lateinit var url : String

        companion object {
            private val gson by lazy { Gson() }
            val DIFF_CALLBACK: DiffUtil.ItemCallback<PokemonListItem> =
                object : DiffUtil.ItemCallback<PokemonListItem>() {
                    override fun areItemsTheSame(oldItem: PokemonListItem, newItem: PokemonListItem): Boolean {
                        return oldItem.name == newItem.name
                    }

                    override fun areContentsTheSame(oldItem: PokemonListItem, newItem: PokemonListItem): Boolean {
                        return gson.toJson(oldItem) == gson.toJson(newItem)
                    }
                }
        }
    }
}