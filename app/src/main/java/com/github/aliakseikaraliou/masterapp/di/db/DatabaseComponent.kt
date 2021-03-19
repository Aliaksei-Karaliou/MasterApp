package com.github.aliakseikaraliou.masterapp.di.db

import com.github.aliakseikaraliou.masterapp.di.ComponentNotInitializedException
import com.github.aliakseikaraliou.masterapp.di.context.ContextComponent
import com.github.aliakseikaraliou.masterapp.di.context.ContextProvider
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

        fun create(contextProvider: ContextProvider): DatabaseComponent {
            databaseComponent = DaggerDatabaseComponent.builder()
                .contextProvider(contextProvider)
                .build()

            return databaseComponent
                ?: throw ComponentNotInitializedException(ContextComponent::class)
        }

        fun get() =
            databaseComponent ?: throw ComponentNotInitializedException(ContextComponent::class)
    }
}