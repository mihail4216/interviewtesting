package com.misendem.interviewproject.data.repository

import com.misendem.interviewproject.data.entity.PostEntity
import io.reactivex.Observable

interface IPostsRepository {
    fun loadPosts():Observable<List<PostEntity>>
}