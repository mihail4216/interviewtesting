package com.misendem.interviewproject.domain.interactors

import com.misendem.interviewproject.data.entity.PostEntity
import com.misendem.interviewproject.data.repository.IPostsRepository
import com.misendem.interviewproject.domain.usecase.LoadPostsUseCase
import io.reactivex.Observable
import javax.inject.Inject

class ListPostsInteractor: LoadPostsUseCase {
    @Inject
    lateinit var postsRepository: IPostsRepository

    override fun loadRepositories(): Observable<List<PostEntity>> {
        return postsRepository.loadPosts()
    }

}