package com.github.aliakseikaraliou.masterapp.di.db

import com.github.aliakseikaraliou.masterapp.db.Database

interface DatabaseProvider {
    fun database(): Database
}