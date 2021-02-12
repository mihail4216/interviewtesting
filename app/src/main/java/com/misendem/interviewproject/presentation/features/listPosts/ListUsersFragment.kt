package com.misendem.interviewproject.presentation.features.listPosts

import androidx.fragment.app.activityViewModels
import com.misendem.interviewproject.R
import com.misendem.interviewproject.databinding.FragmentListUsersBinding
import com.misendem.interviewproject.presentation.base.BaseFragment

class ListUsersFragment : BaseFragment<FragmentListUsersBinding>() {
    private val viewModel: ListUsersViewModel by activityViewModels()
    override fun layoutRes(): Int {
        return R.layout.fragment_list_users
    }

    override fun onViewCreated() {
        binding.viewModel = viewModel
    }
}