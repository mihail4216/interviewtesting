package com.misendem.interviewproject.data.repositoryImpl

import com.misendem.interviewproject.data.dao.PostsDao
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.data.network.JsonPlaceholderApi
import com.misendem.interviewproject.data.repository.IPostsRepository
import io.reactivex.Observable
import javax.inject.Inject

class PostsRepository : IPostsRepository {

    @Inject
    lateinit var network: JsonPlaceholderApi

    @Inject
    lateinit var database: PostsDao

    override fun loadPosts(): Observable<List<UserEntity>> {
        return Observable.merge(
            database.getAllPosts().toObservable(),
            network.getPosts()
                .map { posts -> posts.map { UserEntity(it) } }
                .doOnSuccess {
                    database.insertAll(it)
                }
                .toObservable(),
        ).concatMap {
            Observable.just(it)
        }

    }
}