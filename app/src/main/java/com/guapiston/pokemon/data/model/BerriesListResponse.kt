package com.guapiston.pokemon.data.model

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey

class BerriesListResponse {

lateinit var results : List<Berry>

    @Entity(tableName = "berries")
    class Berry{
        lateinit var name : String
        lateinit var url: String
        @PrimaryKey(autoGenerate = true)
        var id : Int = 0
        var isFavorite = false
        companion object {
            val DIFF_CALLBACK: DiffUtil.ItemCallback<Berry> =
                    object : DiffUtil.ItemCallback<Berry>() {

                        override fun areItemsTheSame(oldItem: Berry, newItem: Berry): Boolean {
                            return oldItem.name == newItem.name
                        }

                        override fun areContentsTheSame(oldItem: Berry, newItem: Berry): Boolean {
                            return oldItem.name == newItem.name
                        }
                    }
        }
    }
}