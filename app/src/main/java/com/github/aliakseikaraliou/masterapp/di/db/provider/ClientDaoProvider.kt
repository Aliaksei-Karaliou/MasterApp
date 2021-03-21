package com.github.aliakseikaraliou.masterapp.di.db.provider

import com.github.aliakseikaraliou.masterapp.db.dao.ClientDao

interface ClientDaoProvider {

    val clientDao: ClientDao
}