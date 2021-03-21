package com.github.aliakseikaraliou.masterapp.feature.clientlist.vm

import androidx.lifecycle.LiveData
import com.github.aliakseikaraliou.masterapp.feature.clientlist.signal.ClientListFragmentSignal
import com.github.aliakseikaraliou.masterapp.model.Client

interface ClientListFragmentViewModel {

    val liveData: LiveData<ClientListFragmentSignal>

    fun loadClients()

    fun addClient(client:Client)
}