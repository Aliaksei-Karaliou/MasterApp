package com.github.aliakseikaraliou.masterapp.feature.clientlist.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.aliakseikaraliou.masterapp.feature.clientlist.signal.ClientListFragmentSignal
import com.github.aliakseikaraliou.masterapp.repo.ClientRepository

class ClientListFragmentViewModelImpl(
    val clientRepository: ClientRepository
) : ViewModel(), ClientListFragmentViewModel {

    override val signalLiveData: MutableLiveData<ClientListFragmentSignal> = MutableLiveData()

    override fun loadClients() {

    }

}