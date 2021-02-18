package com.misendem.interviewproject.domain.interactors

import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.data.repository.IUsersRepository
import com.misendem.interviewproject.domain.usecase.LoadPostsUseCase
import io.reactivex.Observable
import javax.inject.Inject

class ListUserInteractor @Inject constructor(var usersRepository: IUsersRepository) :
    LoadPostsUseCase {
    override fun loadRepositories(): Observable<List<UserEntity>> {
        return usersRepository.loadPosts()
    }

}