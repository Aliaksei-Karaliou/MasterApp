package com.github.aliakseikaraliou.masterapp.repo

import com.github.aliakseikaraliou.masterapp.db.dao.ClientDao
import com.github.aliakseikaraliou.masterapp.db.entity.ClientEntity
import com.github.aliakseikaraliou.masterapp.model.Client
import javax.inject.Inject

class ClientRepository @Inject constructor(private val clientDao: ClientDao) {

    suspend fun loadAll() = clientDao
        .selectAll()
        .map { entity -> entity.toClient() }

    suspend fun add(client: Client): Client {
        return ClientEntity(client)
            .apply { id = clientDao.insert(this) }
            .toClient()
    }
}