package com.github.aliakseikaraliou.masterapp

import android.app.Application
import com.github.aliakseikaraliou.masterapp.di.context.ContextComponent
import com.github.aliakseikaraliou.masterapp.di.db.DatabaseComponent

class MasterAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initDagger()
    }

    private fun initDagger() {
        val contextComponent = ContextComponent.create(this)
        DatabaseComponent.create(contextComponent)
    }
}