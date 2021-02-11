package com.misendem.interviewproject.presentation.features.listPosts

import androidx.fragment.app.activityViewModels
import com.misendem.interviewproject.R
import com.misendem.interviewproject.databinding.FragmentListRepositoryGitHubBinding
import com.misendem.interviewproject.presentation.base.BaseFragment

class ListPostsFragment : BaseFragment<FragmentListRepositoryGitHubBinding>() {
    private val viewModel: ListPostsViewModel by activityViewModels()
    override fun layoutRes(): Int {
        return R.layout.fragment_list_repository_git_hub
    }

    override fun onViewCreated() {
//        viewModel.test()
        binding.viewModel = viewModel
    }
}