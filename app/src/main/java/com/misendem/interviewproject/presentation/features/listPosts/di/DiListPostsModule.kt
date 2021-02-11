package com.misendem.interviewproject.presentation.features.listPosts.di

import com.misendem.interviewproject.data.repository.IPostsRepository
import com.misendem.interviewproject.data.repositoryImpl.PostsRepository
import com.misendem.interviewproject.domain.interactors.ListPostsInteractor
import toothpick.config.Module

class DiListPostsModule : Module() {
    init {
        bind(IPostsRepository::class.java).to(PostsRepository::class.java)
        bind(ListPostsInteractor::class.java).singleton()
    }
}