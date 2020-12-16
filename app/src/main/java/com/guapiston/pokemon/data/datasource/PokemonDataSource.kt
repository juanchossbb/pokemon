package com.guapiston.pokemon.data.datasource

import androidx.paging.PositionalDataSource
import com.guapiston.pokemon.PokemonApp
import com.guapiston.pokemon.data.RetrofitFactory
import com.guapiston.pokemon.data.database.AppDatabase
import com.guapiston.pokemon.data.model.PokemonListResponse
import com.guapiston.pokemon.utils.provideAppDatabase
import com.guapiston.pokemon.utils.provideRetrofitService

class PokemonDataSource : PositionalDataSource<PokemonListResponse.PokemonListItem>(){

    val service by lazy{ provideRetrofitService()}
    val database by lazy { provideAppDatabase() }
    override fun loadRange(
        params: LoadRangeParams,
        callback: LoadRangeCallback<PokemonListResponse.PokemonListItem>
    ) {
        callback.onResult(loadRangeInternal(params.startPosition,params.loadSize))
    }

    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<PokemonListResponse.PokemonListItem>
    ) {
        callback.onResult(loadRangeInternal(0,params.pageSize), params.requestedStartPosition)
    }

    private fun loadRangeInternal(start : Int, count : Int) : List<PokemonListResponse.PokemonListItem>{

        if (PokemonApp.connectedToInternet()) {
            database.pokemonDao().insertPokemonList(
                service.getAvailablePokemon((start / count) + 1, count).doOnError {
                    it.printStackTrace()
                }.blockingFirst().results
            )
        }
        return database.pokemonDao().getPokemonList(count,start)
    }
}