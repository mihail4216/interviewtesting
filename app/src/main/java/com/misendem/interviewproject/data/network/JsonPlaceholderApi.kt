package com.misendem.interviewproject.data.network

import com.misendem.interviewproject.data.model.PostModels
import io.reactivex.Single
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    fun getPosts(): Single<List<PostModels>>
}