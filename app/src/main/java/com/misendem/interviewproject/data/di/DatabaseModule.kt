package com.misendem.interviewproject.data.di

import android.content.Context
import androidx.room.Room
import com.misendem.interviewproject.data.dao.PostsDao
import com.misendem.interviewproject.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule  {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "AppDatabase"
        ).build()
    }

    @Provides
    fun providePostDao(appDatabase: AppDatabase): PostsDao {
        return appDatabase.getPostDao()
    }
}