package com.github.aliakseikaraliou.masterapp.feature.clientlist.signal

import com.github.aliakseikaraliou.masterapp.model.Client

sealed class ClientListFragmentSignal {
    class ClientsLoaded(val clients: List<Client>) : ClientListFragmentSignal()
}