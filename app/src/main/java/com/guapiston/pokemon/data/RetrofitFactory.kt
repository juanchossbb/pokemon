package com.guapiston.pokemon.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val URL = "https://pokeapi.co/api/v2/"
object RetrofitFactory {

    fun getRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl(URL)
            .client(OkHttpClient.Builder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitService::class.java)
    }
}