package com.misendem.interviewproject.domain.interactors

import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.data.repository.IUsersRepository
import com.misendem.interviewproject.domain.usecase.LoadUsersUseCase
import io.reactivex.Observable
import javax.inject.Inject

class ListUsersInteractor : LoadUsersUseCase {
    @Inject
    lateinit var usersRepository: IUsersRepository

    override fun loadUsers(): Observable<List<UserEntity>> {
        return usersRepository.loadUsers()
    }

}