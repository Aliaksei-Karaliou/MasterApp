package com.github.aliakseikaraliou.masterapp.repo

import com.github.aliakseikaraliou.masterapp.db.dao.ClientDao
import javax.inject.Inject

class ClientRepository @Inject constructor(val clientDao: ClientDao)