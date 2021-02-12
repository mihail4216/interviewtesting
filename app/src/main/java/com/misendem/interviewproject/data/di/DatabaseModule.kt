package com.misendem.interviewproject.data.di

import android.content.Context
import androidx.room.Room
import com.misendem.interviewproject.data.dao.PostsDao
import com.misendem.interviewproject.data.database.AppDatabase
import toothpick.config.Module

class DatabaseModule(context: Context) : Module() {

    init {
        val database = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "AppDatabase"
        ).build()
        bind(AppDatabase::class.java).toInstance(
            database
        )
        bind(PostsDao::class.java).toInstance(
            database.getPostDao()
        )


    }
}