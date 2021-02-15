package com.misendem.interviewproject.data.repository

import com.misendem.interviewproject.data.Result
import com.misendem.interviewproject.data.entity.UserEntity
import io.reactivex.Observable

interface IUsersRepository {
    fun loadUsers(): Observable<List<UserEntity>>
    suspend fun loadInfoUserById(id: Int): Result<UserEntity>

}