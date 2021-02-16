package com.misendem.interviewproject.domain.interactors

import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.data.repository.IUsersRepository
import com.misendem.interviewproject.domain.usecase.UserInfoUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserInfoInteractor : UserInfoUseCase {
    @Inject
    lateinit var repository: IUsersRepository

    override suspend fun getUserData(id: Int): Flow<UserEntity> {
        return repository.loadInfoUserById(id)
    }
}