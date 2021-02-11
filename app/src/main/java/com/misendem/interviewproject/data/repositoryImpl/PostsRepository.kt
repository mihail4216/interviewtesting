package com.misendem.interviewproject.data.repositoryImpl

import com.karbon.wizl3.logick.dao.PostsDao
import com.misendem.interviewproject.data.entity.PostEntity
import com.misendem.interviewproject.data.network.JsonPlaceholderApi
import com.misendem.interviewproject.data.repository.IPostsRepository
import io.reactivex.Observable
import javax.inject.Inject

class PostsRepository : IPostsRepository {

    @Inject
    lateinit var network: JsonPlaceholderApi

    @Inject
    lateinit var database: PostsDao

    override fun loadPosts(): Observable<List<PostEntity>> {
        return Observable.merge(
            database.getAllPosts().toObservable(),
            network.getPosts()
                .map { posts -> posts.map { PostEntity(it) } }
                .doOnSuccess {
                    database.insertAll(it)
                }
                .toObservable(),
        ).concatMap {
            Observable.just(it)
        }

    }
}