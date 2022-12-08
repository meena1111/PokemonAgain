package com.example.pokemonagain.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.example.pokemonagain.common.Resource

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes
    val layoutId: Int
) : Fragment(layoutId) {
    abstract val binding: VB
    abstract val viewModel: VM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupSubscribes()
        setupRequests()
    }

    protected open fun initialize() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupSubscribes() {
    }

    protected open fun setupRequests() {
    }

    protected open fun <T> LiveData<Resource<T>>.subscribe(
        onSuccess: (result: T) -> Unit,
        onError: (message: String) -> Unit
    ) {
        observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    onError(it.message.toString())
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { data -> onSuccess(data) }
                }
            }
        }
    }
}
