package com.misendem.interviewproject.data.repositoryImpl

import com.misendem.interviewproject.data.Result
import com.misendem.interviewproject.data.dao.PostsDao
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.data.network.JsonPlaceholderApi
import com.misendem.interviewproject.data.repository.IUsersRepository
import io.reactivex.Observable
import javax.inject.Inject

class UsersRepository : IUsersRepository {

    @Inject
    lateinit var network: JsonPlaceholderApi

    @Inject
    lateinit var database: PostsDao

    override fun loadUsers(): Observable<List<UserEntity>> {
        return Observable.merge(
            database.getAllPosts().toObservable(),
            network.getUsers()
                .map { posts -> posts.map { UserEntity(it) } }
                .doOnSuccess {
                    database.insertAll(it)
                }
                .toObservable(),
        ).concatMap {
            Observable.just(it)
        }

    }

    override suspend fun loadInfoUserById(id: Int): Result<UserEntity> {
        val userNetworkData = network.getUserById(id).await()
        return if (userNetworkData != null) Result.Success(UserEntity(userNetworkData))
        else Result.Error(Exception("Error network"))
    }
}