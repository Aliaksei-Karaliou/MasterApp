package com.github.aliakseikaraliou.masterapp.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.aliakseikaraliou.masterapp.model.Client

@Entity(tableName = "client")
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) var id: Long,
    val name: String,
) {

    constructor(client: Client) : this(client.id, client.name)

    fun toClient() = Client(id, name)
}