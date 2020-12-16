package com.guapiston.pokemon.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.guapiston.pokemon.MainActivity
import com.guapiston.pokemon.R

class SplashActivity : AppCompatActivity(),LifecycleOwner{
val viewModel = SplashViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.loadInitialPokemon()
    }

    override fun onResume() {
        super.onResume()
        viewModel.pokemonLiveData.observe(this){
            launchMainScreen()
        }
    }

    private fun launchMainScreen(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}