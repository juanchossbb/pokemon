package com.guapiston.pokemon.ui.berries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.pokemon.R
import com.guapiston.pokemon.data.model.BerriesListResponse
import com.guapiston.pokemon.ui.pokemon.PokemonListFragment

class BerriesListFragment : Fragment(), BerryClickListener{
lateinit var recyclerView: RecyclerView
    lateinit var adapter: BerriesListAdapter
    val viewmodel = BerriesListViewModel()
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
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        viewmodel.loadBerriesFromDatabase()
        viewmodel.berryiesList.observe(viewLifecycleOwner) {
            showBerryList(it)
        }

    }

    override fun onBerryClicked(berry: BerriesListResponse.Berry) {
        viewmodel.updateBerryInDatabase(berry)
    }

    private fun showBerryList(list : PagedList<BerriesListResponse.Berry>){
        recyclerView.adapter = BerriesListAdapter(this).apply { submitList(list) }
    }

    companion object{
        val instance = BerriesListFragment()
    }
}

interface BerryClickListener{
    fun onBerryClicked(berry : BerriesListResponse.Berry)
}