package com.example.pokemonagain.data.repository

import androidx.lifecycle.liveData
import com.example.pokemonagain.common.Resource
import com.example.pokemonagain.data.remote.apiservice.Pokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val service: Pokemon) {

    fun fetchPokemonNames() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchPokemonNames()))
        } catch (ioException: Exception) {
            emit(Resource.Error(message = ioException.localizedMessage ?: "Error"))
        }

    }
}