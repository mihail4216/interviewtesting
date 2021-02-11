package com.karbon.wizl3.logick.dao

import androidx.room.*
import com.misendem.interviewproject.data.entity.PostEntity
import io.reactivex.Single


@Dao
interface PostsDao {

    @Query("select * from PostEntity")
    fun getAllPosts(): Single<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cardModelEntity: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<PostEntity>)

    @Update
    fun update(cardModelEntity: PostEntity)

    @Delete
    fun delete(cardModelEntity: PostEntity)

}