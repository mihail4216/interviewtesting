package com.misendem.interviewproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karbon.wizl3.logick.dao.PostsDao
import com.misendem.interviewproject.data.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPostDao(): PostsDao
}