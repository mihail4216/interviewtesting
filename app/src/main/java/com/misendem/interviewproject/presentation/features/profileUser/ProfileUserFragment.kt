package com.misendem.interviewproject.presentation.features.profileUser

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.misendem.interviewproject.R
import com.misendem.interviewproject.databinding.FragmentProfileUserBinding
import com.misendem.interviewproject.presentation.base.BaseFragment

class ProfileUserFragment : BaseFragment<FragmentProfileUserBinding>() {
    private val viewModel: ProfileUserViewModel by activityViewModels()
    private val args: ProfileUserFragmentArgs by navArgs()
    override fun layoutRes(): Int {
        return R.layout.fragment_profile_user
    }

    override fun onViewCreated() {
        binding.viewModel = viewModel
        viewModel.setArgs(args)
    }


}