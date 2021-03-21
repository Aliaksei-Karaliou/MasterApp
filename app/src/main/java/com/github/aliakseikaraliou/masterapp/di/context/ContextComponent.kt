package com.github.aliakseikaraliou.masterapp.di.context

import android.content.Context
import com.github.aliakseikaraliou.masterapp.di.ComponentNotInitializedException
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ContextComponent : ContextProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ContextComponent
    }

    companion object {
        private var contextComponent: ContextComponent? = null

        fun create(context: Context) {
            contextComponent = DaggerContextComponent.builder()
                .context(context)
                .build()
        }

        val INSTANCE: ContextComponent
            get() = contextComponent
                ?: throw ComponentNotInitializedException(ContextComponent::class)


    }
}