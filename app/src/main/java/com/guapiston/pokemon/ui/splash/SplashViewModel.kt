package com.guapiston.pokemon.ui.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guapiston.pokemon.data.datasource.PokemonDataSource
import com.guapiston.pokemon.data.model.PokemonListResponse
import com.guapiston.pokemon.utils.provideRetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel(){
    val pokemonLiveData = MutableLiveData<PokemonListResponse>()
    val service by lazy { provideRetrofitService() }

    fun loadInitialPokemon() {
        CoroutineScope(Dispatchers.IO).launch {
            service.getAvailablePokemon(1, 20).subscribe({
                pokemonLiveData.postValue(it)
            }, { it.printStackTrace() })
        }
    }
}