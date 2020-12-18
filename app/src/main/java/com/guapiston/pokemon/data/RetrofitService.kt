package com.guapiston.pokemon.data

import com.guapiston.pokemon.data.model.BerriesListResponse
import com.guapiston.pokemon.data.model.PokemonDetailResponse
import com.guapiston.pokemon.data.model.PokemonListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RetrofitService{

    @GET("pokemon")
    fun getAvailablePokemon(@Query("offset") offset: Int,
                            @Query("limit") limit: Int) : Observable<PokemonListResponse>

    @GET
    fun getPokemonDetails(@Url url : String) : Observable<PokemonDetailResponse>

    @GET("berry")
    fun getAvailableBerries(@Query("offset") offset: Int,
                            @Query("limit") limit: Int) : Observable<BerriesListResponse>
}