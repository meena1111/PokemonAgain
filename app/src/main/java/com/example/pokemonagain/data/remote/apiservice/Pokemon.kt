package com.example.pokemonagain.data.remote.apiservice

import com.example.pokemonagain.models.PokemonModel
import com.example.pokemonagain.models.PokemonResponse
import retrofit2.http.GET

interface Pokemon{

    @GET("pokemon")
    suspend fun fetchPokemonNames(): PokemonResponse<PokemonModel>
}
