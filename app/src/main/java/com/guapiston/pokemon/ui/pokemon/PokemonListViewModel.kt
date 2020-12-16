package com.guapiston.pokemon.ui.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.guapiston.pokemon.data.model.PokemonListResponse
import com.guapiston.pokemon.data.source.PokemonDataSourceFactory

private const val PAGE_SIZE = 50
class PokemonListViewModel : ViewModel(){
    lateinit var pokemonList: LiveData<PagedList<PokemonListResponse.PokemonListItem>>
fun loadPokemonFromDatabase(){
    val config = PagedList.Config.Builder()
        .setPrefetchDistance(PAGE_SIZE / 2)
        .setPageSize(PAGE_SIZE)
        .setEnablePlaceholders(false)
        .build()
    pokemonList = LivePagedListBuilder(PokemonDataSourceFactory(), config).build()
}

}