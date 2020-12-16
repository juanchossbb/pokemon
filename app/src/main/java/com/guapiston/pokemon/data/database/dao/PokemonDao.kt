package com.guapiston.pokemon.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.guapiston.pokemon.data.model.PokemonListResponse

@Dao
interface PokemonDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPokemonList(pokemons: List<PokemonListResponse.PokemonListItem>)

    @Query("SELECT * FROM pokemon limit :pagesize offset :initial")
    fun getPokemonList(pagesize: Int, initial: Int): List<PokemonListResponse.PokemonListItem>
}