package com.example.pokemonagain.models

import com.example.pokemonagain.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class PokemonModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String
) : IBaseDiffModel<Int>

