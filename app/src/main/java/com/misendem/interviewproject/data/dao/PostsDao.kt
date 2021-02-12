package com.misendem.interviewproject.data.dao

import androidx.room.*
import com.misendem.interviewproject.data.entity.UserEntity
import io.reactivex.Single


@Dao
interface PostsDao {

    @Query("select * from UserEntity")
    fun getAllPosts(): Single<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cardModelEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<UserEntity>)

    @Update
    fun update(cardModelEntity: UserEntity)

    @Delete
    fun delete(cardModelEntity: UserEntity)

}