package com.misendem.interviewproject

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.internal.modules.ApplicationContextModule
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule


@HiltAndroidApp
class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }
}