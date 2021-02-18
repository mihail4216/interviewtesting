package com.misendem.interviewproject.data.repository

import com.misendem.interviewproject.data.entity.UserEntity
import io.reactivex.Observable

interface IUsersRepository {
    fun loadPosts(): Observable<List<UserEntity>>
}