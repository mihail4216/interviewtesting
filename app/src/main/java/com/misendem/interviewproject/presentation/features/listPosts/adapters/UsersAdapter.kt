package com.misendem.interviewproject.presentation.features.listPosts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.databinding.ViewPostItemBinding
import com.misendem.interviewproject.presentation.extension.autoNotify
import kotlin.properties.Delegates

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.PostViewHolder>() {
    var onClickItemPostListener: (UserEntity) -> Unit = {}
    private var listUsers: List<UserEntity> by Delegates.observable(emptyList()) { prop, oldList, newList ->
        autoNotify(oldList, newList) { o, n ->
            o == n
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            ViewPostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(listUsers[position])
        holder.itemView.setOnClickListener { onClickItemPostListener(listUsers[position]) }
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }

    fun addAll(items: List<UserEntity>) {
        listUsers = items
    }

    fun clearList() {
        listUsers = emptyList()
    }

    class PostViewHolder(private val binding: ViewPostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userEntity: UserEntity) {
            binding.post = userEntity
        }
    }
}
