package com.github.aliakseikaraliou.masterapp.di.db

import android.content.Context
import androidx.room.Room
import com.github.aliakseikaraliou.masterapp.db.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun database(context: Context) = Room
        .databaseBuilder(context, Database::class.java, "db")
        .build()
}
