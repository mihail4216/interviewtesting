package com.misendem.interviewproject.data.repository

import com.misendem.interviewproject.data.entity.UserEntity
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface IUsersRepository {
    fun loadUsers(): Observable<List<UserEntity>>
    suspend fun loadInfoUserById(id: Int): Flow<UserEntity>

}