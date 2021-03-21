package com.github.aliakseikaraliou.masterapp

import android.app.Application
import com.github.aliakseikaraliou.masterapp.di.context.ContextComponent
import com.github.aliakseikaraliou.masterapp.di.db.DatabaseComponent
import com.github.aliakseikaraliou.masterapp.di.repo.RepositoryComponent

class MasterAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDagger()
    }

    private fun initDagger() {
        ContextComponent.create(this)
        DatabaseComponent.create(ContextComponent.INSTANCE)
        RepositoryComponent.create(DatabaseComponent.INSTANCE)
    }
}