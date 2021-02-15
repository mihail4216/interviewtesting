package com.misendem.interviewproject.presentation.features.listPosts.di

import com.misendem.interviewproject.data.repository.IUsersRepository
import com.misendem.interviewproject.data.repositoryImpl.UsersRepository
import com.misendem.interviewproject.domain.interactors.ListUsersInteractor
import toothpick.config.Module

class DiListPostsModule : Module() {
    init {
        bind(IUsersRepository::class.java).to(UsersRepository::class.java)
        bind(ListUsersInteractor::class.java).singleton()
    }
}