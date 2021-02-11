package com.misendem.interviewproject

import android.app.Application
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.misendem.interviewproject.data.di.ApplicationModule
import com.misendem.interviewproject.data.di.DatabaseModule
import com.misendem.interviewproject.data.di.NetworkModule
import com.misendem.interviewproject.presentation.features.listPosts.di.DiListPostsModule
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.ktp.KTP

class MainApplication : MultiDexApplication() {
    companion object {
        val APP_NAME = MainApplication::class.java.name
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        KTP.setConfiguration(if (BuildConfig.DEBUG) Configuration.forDevelopment() else Configuration.forProduction())
        KTP.openScope(APP_NAME).installModules(
            ApplicationModule(this),
            NetworkModule(),
            DatabaseModule(this)
        )
    }
}