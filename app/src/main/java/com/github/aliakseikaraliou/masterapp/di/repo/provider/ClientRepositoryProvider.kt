package com.github.aliakseikaraliou.masterapp.di.repo.provider

import com.github.aliakseikaraliou.masterapp.repo.ClientRepository

interface ClientRepositoryProvider {

    val clientRepository: ClientRepository
}