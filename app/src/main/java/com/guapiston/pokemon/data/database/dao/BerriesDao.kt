package com.guapiston.pokemon.data.database.dao

import androidx.room.*
import com.guapiston.pokemon.data.model.BerriesListResponse
import com.guapiston.pokemon.data.model.PokemonListResponse

@Dao
interface BerriesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBerriesList(berries: List<BerriesListResponse.Berry>)

    @Query("SELECT * FROM berries limit :pagesize offset :initial")
    fun getBerriesList(pagesize: Int, initial: Int): List<BerriesListResponse.Berry>

    @Update
    fun updateBerry(berry : BerriesListResponse.Berry)
}