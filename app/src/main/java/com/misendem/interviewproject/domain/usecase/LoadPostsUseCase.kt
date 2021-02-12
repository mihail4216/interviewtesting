package com.misendem.interviewproject.domain.usecase

import com.misendem.interviewproject.data.entity.UserEntity
import io.reactivex.Observable

interface LoadPostsUseCase {
    fun loadRepositories(): Observable<List<UserEntity>>
}