package com.guapiston.pokemon.ui.pokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guapiston.pokemon.data.model.PokemonDetailResponse
import com.guapiston.pokemon.utils.provideRetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDetailsViewModel : ViewModel(){
    val service by lazy { provideRetrofitService() }
    val detailsLiveData = MutableLiveData<PokemonDetailResponse>()
    fun getProductDetails(url : String) {
        CoroutineScope(Dispatchers.IO).launch {
            service.getPokemonDetails(url).subscribe ({
                detailsLiveData.postValue(it)
            },{it.printStackTrace()})
        }
    }
}