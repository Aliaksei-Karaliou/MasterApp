package com.github.aliakseikaraliou.masterapp.feature.clientlist.di

import androidx.lifecycle.ViewModelProvider
import com.github.aliakseikaraliou.masterapp.feature.clientlist.ui.ClientListFragment
import com.github.aliakseikaraliou.masterapp.feature.clientlist.vm.ClientListFragmentViewModel
import com.github.aliakseikaraliou.masterapp.feature.clientlist.vm.ClientListFragmentViewModelImpl
import com.github.aliakseikaraliou.masterapp.feature.clientlist.vm.ClientListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ClientListFragmentModule {

    @Provides
    fun viewModel(
        fragment: ClientListFragment,
        viewModelFactory: ClientListViewModelFactory
    ): ClientListFragmentViewModel =
        ViewModelProvider(fragment, viewModelFactory)
            .get(ClientListFragmentViewModelImpl::class.java)
}