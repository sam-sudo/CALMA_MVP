package com.ck.calma

import android.app.Application
import di.getSharedModules
import org.koin.core.context.startKoin

class CalmaApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(getSharedModules())
        }
    }
}