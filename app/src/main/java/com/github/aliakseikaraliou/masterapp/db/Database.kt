package com.github.aliakseikaraliou.masterapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.aliakseikaraliou.masterapp.db.dao.ClientDao
import com.github.aliakseikaraliou.masterapp.db.entity.ClientEntity

@Database(entities = [ClientEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun clientDao(): ClientDao
}