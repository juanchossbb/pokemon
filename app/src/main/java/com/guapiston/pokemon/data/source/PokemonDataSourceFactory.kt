package com.guapiston.pokemon.data.source

import androidx.paging.DataSource
import com.guapiston.pokemon.data.model.PokemonListResponse

class PokemonDataSourceFactory : DataSource.Factory<Int,PokemonListResponse.PokemonListItem>(){
    val dataSource = PokemonDataSource()
    override fun create(): DataSource<Int, PokemonListResponse.PokemonListItem> {
        return  dataSource
    }
}