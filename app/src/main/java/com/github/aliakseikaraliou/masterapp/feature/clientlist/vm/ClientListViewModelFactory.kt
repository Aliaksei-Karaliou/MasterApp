package com.github.aliakseikaraliou.masterapp.feature.clientlist.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.aliakseikaraliou.masterapp.repo.ClientRepository
import javax.inject.Inject

class ClientListViewModelFactory @Inject constructor(
    private val clientRepository: ClientRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = when (modelClass) {
        ClientListFragmentViewModelImpl::class.java -> ClientListFragmentViewModelImpl(clientRepository) as T
        else -> throw Exception()
    }
}