package com.misendem.interviewproject.domain.usecase

import com.misendem.interviewproject.data.Result
import com.misendem.interviewproject.data.entity.UserEntity

interface UserInfoUseCase {
    suspend fun getUserData(id:Int): Result<UserEntity>
}