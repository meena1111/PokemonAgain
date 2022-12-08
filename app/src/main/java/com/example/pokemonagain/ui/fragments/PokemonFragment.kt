package com.example.pokemonagain.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemonagain.R
import com.example.pokemonagain.base.BaseFragment
import com.example.pokemonagain.databinding.FragmentPokemonBinding
import com.example.pokemonagain.ui.adapters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PokemonFragment :
    BaseFragment<PokemonViewModel, FragmentPokemonBinding>(R.layout.fragment_pokemon) {

    private val adapter = PokemonAdapter()
    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel: PokemonViewModel by viewModels()

    override fun initialize() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    override fun setupSubscribes() {
        viewModel.fetchPokemonNames().subscribe(
            onSuccess = {
                adapter.submitList(it.results)
            },
            onError = {
                Log.e("pokemon", it)
            }
        )
    }
}