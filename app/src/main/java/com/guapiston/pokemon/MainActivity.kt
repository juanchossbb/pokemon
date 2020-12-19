package com.guapiston.pokemon

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.guapiston.pokemon.ui.berries.BerriesListFragment
import com.guapiston.pokemon.ui.pokemon.PokemonDetailsFragment
import com.guapiston.pokemon.ui.pokemon.PokemonListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_pokemon, R.id.navigation_berries))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_pokemon ->{
                    launchPokemonListFragment()
                    true
                }
                R.id.navigation_berries -> {
                    launchBerriesListFragment()
                    true
                }
                else ->false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        hideBackButton()
    }

    private fun launchPokemonListFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container,PokemonListFragment.instance).commit()
    }

    private fun launchBerriesListFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container,BerriesListFragment()).commit()
    }

    fun launchPokemonDetailsFragment(url : String){
        supportFragmentManager?.beginTransaction()?.add(R.id.container, PokemonDetailsFragment.getInstance(url))?.addToBackStack(null)?.commit()
    }

    private fun hideBackButton(){
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setHomeButtonEnabled(false)
        }
    }

    fun showBackButton(){
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
           android.R.id.home -> {
               onBackPressed()
               hideBackButton()
           }
        }
        return super.onOptionsItemSelected(item)
    }
}