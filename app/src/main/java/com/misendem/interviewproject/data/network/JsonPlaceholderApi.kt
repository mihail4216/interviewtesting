package com.misendem.interviewproject.data.network

import com.misendem.interviewproject.data.model.UserModel
import io.reactivex.Single
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/users")
    fun getPosts(): Single<List<UserModel>>
}