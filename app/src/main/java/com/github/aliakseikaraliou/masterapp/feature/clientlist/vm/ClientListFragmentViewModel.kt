package com.github.aliakseikaraliou.masterapp.feature.clientlist.vm

import androidx.lifecycle.LiveData
import com.github.aliakseikaraliou.masterapp.feature.clientlist.signal.ClientListFragmentSignal

interface ClientListFragmentViewModel {

    val signalLiveData: LiveData<ClientListFragmentSignal>

    fun loadClients()
}