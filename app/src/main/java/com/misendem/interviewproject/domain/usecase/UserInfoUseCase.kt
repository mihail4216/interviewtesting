package com.misendem.interviewproject.domain.usecase

import com.misendem.interviewproject.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserInfoUseCase {
    suspend fun getUserData(id:Int): Flow<UserEntity>
}