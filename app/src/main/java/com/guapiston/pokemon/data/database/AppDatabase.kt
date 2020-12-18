package com.guapiston.pokemon.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guapiston.pokemon.data.database.dao.BerriesDao
import com.guapiston.pokemon.data.database.dao.PokemonDao
import com.guapiston.pokemon.data.model.BerriesListResponse
import com.guapiston.pokemon.data.model.PokemonListResponse

@Database(entities = [PokemonListResponse.PokemonListItem::class, BerriesListResponse.Berry::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun pokemonDao() : PokemonDao
    abstract fun berriesDao() : BerriesDao
}