package com.guapiston.pokemon.data.source

import androidx.paging.PositionalDataSource
import com.guapiston.pokemon.PokemonApp
import com.guapiston.pokemon.data.model.BerriesListResponse
import com.guapiston.pokemon.data.model.PokemonListResponse
import com.guapiston.pokemon.utils.provideAppDatabase
import com.guapiston.pokemon.utils.provideRetrofitService

class BerryDataSource : PositionalDataSource<BerriesListResponse.Berry>(){
    val database by lazy { provideAppDatabase()}
    val service by lazy{ provideRetrofitService()}
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<BerriesListResponse.Berry>) {
        callback.onResult(loadRangeInternal(params.startPosition,params.loadSize))
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<BerriesListResponse.Berry>) {
        callback.onResult(loadRangeInternal(0,params.pageSize), params.requestedStartPosition)
    }

    fun loadRangeInternal(start : Int, count : Int) : List<BerriesListResponse.Berry>{

        if (PokemonApp.connectedToInternet()) {
            database.berriesDao().insertBerriesList(
                    service.getAvailableBerries(start, count).doOnError {
                        it.printStackTrace()
                    }.blockingFirst().results
            )
        }
        return database.berriesDao().getBerriesList(count,start)
    }


}