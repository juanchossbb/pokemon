package com.guapiston.pokemon.utils

import android.os.Build
import androidx.room.Room
import com.guapiston.pokemon.PokemonApp
import com.guapiston.pokemon.data.RetrofitFactory
import com.guapiston.pokemon.data.RetrofitService
import com.guapiston.pokemon.data.database.AppDatabase

fun provideAppDatabase(): AppDatabase = Room.databaseBuilder(
    PokemonApp.applicationContext(),
    AppDatabase::class.java,
    Build.DEVICE
).build()

fun provideRetrofitService(): RetrofitService = RetrofitFactory.getRetrofitService()
