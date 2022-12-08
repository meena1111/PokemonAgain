package com.example.pokemonagain.ui.fragments

import com.example.pokemonagain.base.BaseViewModel
import com.example.pokemonagain.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : BaseViewModel() {
    fun fetchPokemonNames() = repository.fetchPokemonNames()
}
