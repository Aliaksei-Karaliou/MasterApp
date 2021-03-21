package com.github.aliakseikaraliou.masterapp.feature.clientlist.vm

import androidx.lifecycle.*
import com.github.aliakseikaraliou.masterapp.feature.clientlist.signal.ClientListFragmentSignal
import com.github.aliakseikaraliou.masterapp.model.Client
import com.github.aliakseikaraliou.masterapp.repo.ClientRepository
import com.github.aliakseikaraliou.masterapp.utils.postOnce
import com.github.aliakseikaraliou.masterapp.utils.liveDataOf
import kotlinx.coroutines.Dispatchers

class ClientListFragmentViewModelImpl(
    private val clientRepository: ClientRepository,
) : ViewModel(), ClientListFragmentViewModel {

    override val liveData: MediatorLiveData<ClientListFragmentSignal> = MediatorLiveData()

    override fun loadClients() {
        val clientsLoadedLiveData =
            liveDataOf(viewModelScope, Dispatchers.IO) { clientRepository.loadAll() }

        val clientsLoadedSignalLiveData =
            Transformations.map(clientsLoadedLiveData) { data ->
                if (data.isSucceed) {
                    ClientListFragmentSignal.ClientListUpdated(data.get())
                } else {
                    ClientListFragmentSignal.Error(ClientListFragmentSignal.ClientListUpdated::class,
                        data.exception())
                }

            }

        liveData.postOnce(clientsLoadedSignalLiveData)
    }

    override fun addClient(client: Client) {
        val clientAddedLiveData =
            liveDataOf(viewModelScope, Dispatchers.IO) { clientRepository.add(client) }

        val clientAddedSignalLiveData = Transformations.map(clientAddedLiveData) { data ->
            if (data.isSucceed) {
                ClientListFragmentSignal.ClientAdded(client)
            } else {
                ClientListFragmentSignal.Error(ClientListFragmentSignal.ClientListUpdated::class,
                    data.exception())
            }
        }

        liveData.postOnce(clientAddedSignalLiveData){
            loadClients()
        }
    }
}