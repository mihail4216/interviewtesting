package com.misendem.interviewproject.data.repositoryImpl

import com.misendem.interviewproject.data.dao.PostsDao
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.data.network.JsonPlaceholderApi
import com.misendem.interviewproject.data.repository.IUsersRepository
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
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

    override suspend fun loadInfoUserById(id: Int): Flow<UserEntity> {
        return flow {
            emit(database.getUserById(id))
            emit(UserEntity(network.getUserById(id)))
        }
    }

}