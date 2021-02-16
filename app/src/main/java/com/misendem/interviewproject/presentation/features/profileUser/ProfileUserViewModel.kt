package com.misendem.interviewproject.presentation.features.profileUser

import androidx.lifecycle.*
import com.misendem.interviewproject.MainApplication
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.domain.interactors.UserInfoInteractor
import com.misendem.interviewproject.presentation.features.profileUser.di.DiUserInfoModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import toothpick.ktp.KTP
import javax.inject.Inject

class ProfileUserViewModel : ViewModel() {

    @Inject
    lateinit var userInteractor: UserInfoInteractor

    private val mUserInfo: MutableLiveData<UserEntity> = MutableLiveData()
    private val mError: MutableLiveData<String> = MutableLiveData()

    val userInfo: LiveData<UserEntity> = mUserInfo
    val errorIsVisible: LiveData<Boolean> = mError.map { !it.isNullOrBlank() }
    val errorText: LiveData<String> = mError


    init {
        KTP.openScopes(MainApplication.APP_NAME, this)
            .installModules(DiUserInfoModule())
            .inject(this)
    }

    fun setArgs(args: ProfileUserFragmentArgs) {
        viewModelScope.launch(Dispatchers.IO) {
            userInteractor.getUserData(args.id)
                .catch { error ->
                    error.printStackTrace()
                    withContext(Dispatchers.Main) {
                        mError.value = error.message
                    }
                }
                .collect {
                    withContext(Dispatchers.Main) {
                        mUserInfo.value = it
                    }
                }
        }
    }

}