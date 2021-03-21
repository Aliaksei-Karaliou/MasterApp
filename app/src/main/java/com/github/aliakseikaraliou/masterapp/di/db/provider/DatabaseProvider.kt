package com.github.aliakseikaraliou.masterapp.di.db.provider

import com.github.aliakseikaraliou.masterapp.db.Database

interface DatabaseProvider {
    fun database(): Database
}