package com.guapiston.pokemon.data

import com.guapiston.pokemon.data.model.PokemonListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService{

    @GET("pokemon")
    fun getAvailablePokemon(@Query("page") page: Int,
                            @Query("limit") limit: Int) : Observable<PokemonListResponse>
}