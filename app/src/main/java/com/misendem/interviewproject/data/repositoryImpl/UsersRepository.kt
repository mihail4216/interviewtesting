package com.misendem.interviewproject.data.repositoryImpl

import com.misendem.interviewproject.data.dao.PostsDao
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.data.network.JsonPlaceholderApi
import com.misendem.interviewproject.data.repository.IUsersRepository
import io.reactivex.Observable
import javax.inject.Inject

class UsersRepository @Inject constructor(
    var network: JsonPlaceholderApi,
    var database: PostsDao
) : IUsersRepository {

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