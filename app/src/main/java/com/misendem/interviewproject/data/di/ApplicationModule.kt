package com.misendem.interviewproject.data.di

import android.content.Context
import toothpick.config.Module

class ApplicationModule(context: Context) : Module() {
    init {
        bind(Context::class.java).withName("AppContext").toInstance(context)
    }
}