package com.misendem.interviewproject.presentation.features.profileUser

import androidx.lifecycle.*
import com.misendem.interviewproject.MainApplication
import com.misendem.interviewproject.data.Result
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.domain.interactors.UserInfoInteractor
import com.misendem.interviewproject.presentation.features.profileUser.di.DiUserInfoModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import toothpick.ktp.KTP
import javax.inject.Inject

class ProfileUserViewModel : ViewModel() {
    fun setArgs(args: ProfileUserFragmentArgs) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = userInteractor.getUserData(args.id)) {
                is Result.Success -> {
                    withContext(Dispatchers.Main) {
                        mUserInfo.value = result.data
                    }
                }
                is Result.Error -> {
                    withContext(Dispatchers.Main) {
                        mError.value = result.exception.toString()
                    }
                }
            }
        }
    }

    @Inject
    lateinit var userInteractor: UserInfoInteractor

    private val mUserInfo: MutableLiveData<UserEntity> = MutableLiveData()
    private val mError: MutableLiveData<String> = MutableLiveData()

    val userInfo: LiveData<UserEntity> = mUserInfo
    val errorIsVisible: LiveData<Boolean> = mError.map { it.isNullOrBlank() }

    init {
        KTP.openScopes(MainApplication.APP_NAME, this)
            .installModules(DiUserInfoModule())
            .inject(this)
    }

}