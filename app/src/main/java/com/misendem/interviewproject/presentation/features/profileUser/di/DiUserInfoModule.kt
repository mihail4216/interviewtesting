package com.misendem.interviewproject.presentation.features.profileUser.di

import com.misendem.interviewproject.data.repository.IUsersRepository
import com.misendem.interviewproject.data.repositoryImpl.UsersRepository
import com.misendem.interviewproject.domain.interactors.ListUsersInteractor
import com.misendem.interviewproject.domain.interactors.UserInfoInteractor
import toothpick.config.Module

class DiUserInfoModule : Module() {
    init {
        bind(IUsersRepository::class.java).to(UsersRepository::class.java)
        bind(UserInfoInteractor::class.java).singleton()
    }
}