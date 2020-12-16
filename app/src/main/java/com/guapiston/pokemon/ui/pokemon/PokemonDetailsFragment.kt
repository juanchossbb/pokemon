package com.guapiston.pokemon.ui.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.pokemon.R
import com.guapiston.pokemon.data.model.PokemonDetailResponse

class PokemonDetailsFragment : Fragment(){

    lateinit var tvTitle : TextView
    lateinit var tvExperienceValue : TextView
    lateinit var tvHeightValue : TextView
    lateinit var pbHp : ProgressBar
    lateinit var pbAttack : ProgressBar
    lateinit var pbDefense : ProgressBar
    lateinit var pbSpAttack : ProgressBar
    lateinit var pbSpDefense : ProgressBar
    lateinit var pbSpeed : ProgressBar
    lateinit var rvSkills : RecyclerView
    lateinit var pbLoading : ProgressBar
    val viewModel = PokemonDetailsViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_details,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle = view.findViewById(R.id.tv_details_name)
        tvExperienceValue = view.findViewById(R.id.tv_details_experience_value)
        tvHeightValue = view.findViewById(R.id.tv_details_heigth_value)
        pbHp = view.findViewById(R.id.pb_detail_hp)
        pbAttack = view.findViewById(R.id.pb_detail_attack)
        pbDefense = view.findViewById(R.id.pb_detail_defense)
        pbSpAttack = view.findViewById(R.id.pb_detail_sp_attack)
        pbSpDefense = view.findViewById(R.id.pb_detail_sp_defense)
        pbSpeed = view.findViewById(R.id.pb_detail_speed)
        rvSkills = view.findViewById(R.id.rv_details_skills)
        rvSkills.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        pbLoading = view.findViewById(R.id.pb_loading)

        val url = arguments?.getString("url")
        url?.let {
            viewModel.getProductDetails(it)
            viewModel.detailsLiveData.observe(viewLifecycleOwner) {
                showDetails(it)
            }
        }

    }

    private fun showDetails(details : PokemonDetailResponse){

        tvTitle.text = details.name
        tvExperienceValue.text = details.experience.toString()
        tvHeightValue.text = details.height.toString()
        pbHp.progress = details.stats[0].baseStat
        pbAttack.progress = details.stats[1].baseStat
        pbDefense.progress = details.stats[2].baseStat
        pbSpAttack.progress = details.stats[3].baseStat
        pbSpDefense.progress = details.stats[4].baseStat
        pbSpeed.progress = details.stats[5].baseStat
        rvSkills.adapter = PokemonSkillsAdapter(details.abilities)
        pbLoading.visibility = View.GONE
    }

    companion object{

        fun getInstance(url : String) : PokemonDetailsFragment{
            return PokemonDetailsFragment().apply {
                arguments = bundleOf("url" to url)
            }
        }
    }
}