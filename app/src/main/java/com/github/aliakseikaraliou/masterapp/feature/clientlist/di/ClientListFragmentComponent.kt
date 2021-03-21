package com.github.aliakseikaraliou.masterapp.feature.clientlist.di

import com.github.aliakseikaraliou.masterapp.di.repo.RepositoryComponent
import com.github.aliakseikaraliou.masterapp.di.repo.provider.ClientRepositoryProvider
import com.github.aliakseikaraliou.masterapp.feature.clientlist.ui.ClientListFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [ClientRepositoryProvider::class],
    modules = [ClientListFragmentModule::class]
)
interface ClientListFragmentComponent {

    fun inject(fragment: ClientListFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun fragment(fragment: ClientListFragment): Builder

        fun clientRepositoryProvider(provider: ClientRepositoryProvider): Builder

        fun build(): ClientListFragmentComponent
    }

    companion object {

        fun inject(fragment: ClientListFragment) = DaggerClientListFragmentComponent.builder()
            .fragment(fragment)
            .clientRepositoryProvider(RepositoryComponent.INSTANCE)
            .build()
            .inject(fragment)
    }
}