package com.guapiston.pokemon.ui.berries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.guapiston.pokemon.data.model.BerriesListResponse
import com.guapiston.pokemon.data.model.PokemonListResponse
import com.guapiston.pokemon.data.source.BerryDatasourceFactory
import com.guapiston.pokemon.data.source.PokemonDataSourceFactory
import com.guapiston.pokemon.utils.provideAppDatabase
import com.guapiston.pokemon.utils.provideRetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val PAGE_SIZE = 50
class BerriesListViewModel : ViewModel(){

    val database by lazy { provideAppDatabase() }

    lateinit var berryiesList: LiveData<PagedList<BerriesListResponse.Berry>>
    fun loadBerriesFromDatabase(){
        val config = PagedList.Config.Builder()
            .setPrefetchDistance(PAGE_SIZE / 2)
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()
        berryiesList = LivePagedListBuilder(BerryDatasourceFactory(), config).build()
    }
    fun updateBerryInDatabase(berry : BerriesListResponse.Berry){
        CoroutineScope(Dispatchers.IO).launch {
           database.berriesDao().updateBerry(berry)
        }
    }

}