package com.example.pokemonagain.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonagain.base.BaseDiffUtilItemCallback
import com.example.pokemonagain.databinding.ItemPokemonBinding
import com.example.pokemonagain.models.PokemonModel

class PokemonAdapter :
    ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class PokemonViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: PokemonModel) {
            binding.pokemonNameTextView.text = model.name
        }

    }


}