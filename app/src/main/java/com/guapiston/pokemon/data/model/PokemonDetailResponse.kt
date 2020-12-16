package com.guapiston.pokemon.data.model

import com.google.gson.annotations.SerializedName

class PokemonDetailResponse {
    lateinit var name : String
    @SerializedName("base_experience")
    var experience : Int = 0
    var height : Int = 0
    lateinit var stats : List<Stat>
    lateinit var abilities : List<Ability>

    class Stat{
        @SerializedName("base_stat")
        var baseStat : Int = 0
        lateinit var stat : Info


    }

    class Ability{
        @SerializedName("is_hidden")
        var isHidden = false
        var slot : Int = 0
        lateinit var ability : Info

    }
    class Info{
        lateinit var name : String
        lateinit var url : String
    }


}