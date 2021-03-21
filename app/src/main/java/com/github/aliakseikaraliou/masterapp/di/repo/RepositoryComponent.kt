package com.github.aliakseikaraliou.masterapp.di.repo

import com.github.aliakseikaraliou.masterapp.di.ComponentNotInitializedException
import com.github.aliakseikaraliou.masterapp.di.db.provider.DatabaseProvider
import com.github.aliakseikaraliou.masterapp.di.repo.provider.ClientRepositoryProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DatabaseProvider::class]
)
interface RepositoryComponent : ClientRepositoryProvider {

    companion object {

        private var repositoryComponent: RepositoryComponent? = null

        fun create(databaseProvider: DatabaseProvider): RepositoryComponent {
            repositoryComponent = DaggerRepositoryComponent.builder()
                .databaseProvider(databaseProvider)
                .build()

            return repositoryComponent
                ?: throw ComponentNotInitializedException(RepositoryComponent::class)
        }

        val INSTANCE: RepositoryComponent
            get() = repositoryComponent
                ?: throw ComponentNotInitializedException(RepositoryComponent::class)

    }
}