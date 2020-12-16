package com.guapiston.pokemon.ui.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.pokemon.R
import com.guapiston.pokemon.data.model.PokemonListResponse

class PokemonListFragment : Fragment(){
    val viewModel = PokemonListViewModel()
lateinit var recyclerView : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        viewModel.loadPokemonFromDatabase()
        viewModel.pokemonList.observe(viewLifecycleOwner) {
            showPokemonList(it)
        }

    }

    private fun showPokemonList(list: PagedList<PokemonListResponse.PokemonListItem>) {
        recyclerView.adapter = PokemonListAdapter().apply { submitList(list) }
    }
}