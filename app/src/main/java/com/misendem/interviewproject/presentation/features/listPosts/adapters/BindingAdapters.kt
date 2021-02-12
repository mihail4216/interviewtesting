package com.misendem.interviewproject.presentation.features.listPosts.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.misendem.interviewproject.data.entity.UserEntity


@BindingAdapter("post:adapterListLoader", "post:onClickItem")
fun RecyclerView.adapterListLoader(
    listUsers: List<UserEntity>?,
    onClickPostItemListener: (UserEntity) -> Unit
) {
    if (listUsers.isNullOrEmpty()) return
    val adapter = UsersAdapter()
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    adapter.addAll(listUsers)
    adapter.onClickItemPostListener = onClickPostItemListener
    this.adapter = adapter
}
