package com.github.aliakseikaraliou.masterapp.di.db

import com.github.aliakseikaraliou.masterapp.di.ComponentNotInitializedException
import com.github.aliakseikaraliou.masterapp.di.context.ContextProvider
import com.github.aliakseikaraliou.masterapp.di.db.provider.ClientDaoProvider
import com.github.aliakseikaraliou.masterapp.di.db.provider.DatabaseProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [ContextProvider::class],
    modules = [DatabaseModule::class]
)
@Singleton
interface DatabaseComponent : DatabaseProvider {

    companion object {

        private var databaseComponent: DatabaseComponent? = null

        fun create(contextProvider: ContextProvider) {
            databaseComponent = DaggerDatabaseComponent.builder()
                .contextProvider(contextProvider)
                .build()
        }

        val INSTANCE: DatabaseComponent
            get() = databaseComponent
                ?: throw ComponentNotInitializedException(DatabaseComponent::class)

    }
}