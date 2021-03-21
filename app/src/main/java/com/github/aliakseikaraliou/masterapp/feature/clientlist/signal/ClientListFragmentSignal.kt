package com.github.aliakseikaraliou.masterapp.feature.clientlist.signal

import com.github.aliakseikaraliou.masterapp.model.Client
import kotlin.reflect.KClass

sealed class ClientListFragmentSignal {
    class ClientListUpdated(val clients: List<Client>) : ClientListFragmentSignal()

    class ClientAdded(val client: Client) : ClientListFragmentSignal()

    class Error(
        val rootSignal: KClass<out ClientListFragmentSignal>,
        val throwable: Throwable,
    ) :
        ClientListFragmentSignal()
}