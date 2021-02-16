package com.misendem.interviewproject.data.network

import com.misendem.interviewproject.data.model.UserModel
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderApi {

    @GET("/users")
    fun getUsers(): Single<List<UserModel>>

    @GET("/users/{id}")
    suspend fun getUserById(@Path("id") id:Int):UserModel
}