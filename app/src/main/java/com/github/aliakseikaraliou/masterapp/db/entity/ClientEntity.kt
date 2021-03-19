package com.github.aliakseikaraliou.masterapp.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "client")
data class ClientEntity(
    @PrimaryKey val id: Int,
    val name: String,
)