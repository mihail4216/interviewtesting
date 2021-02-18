package com.misendem.interviewproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.misendem.interviewproject.data.dao.PostsDao
import com.misendem.interviewproject.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPostDao(): PostsDao
}