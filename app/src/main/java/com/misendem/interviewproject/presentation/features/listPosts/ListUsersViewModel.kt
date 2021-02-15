package com.misendem.interviewproject.presentation.features.listPosts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misendem.interviewproject.MainApplication
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.domain.interactors.ListUsersInteractor
import com.misendem.interviewproject.presentation.extension.TAG
import com.misendem.interviewproject.presentation.features.listPosts.di.DiListPostsModule
import com.misendem.interviewproject.presentation.helpers.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import toothpick.ktp.KTP
import javax.inject.Inject

class ListUsersViewModel : ViewModel() {

    @Inject
    lateinit var interactor: ListUsersInteractor
    private val disposables = CompositeDisposable()

    private val mListUsers = MutableLiveData<List<UserEntity>>()
    private val mSelectableUser = SingleLiveEvent<UserEntity>()

    val onClickItem: (UserEntity) -> Unit = {
        mSelectableUser.value = it
        Log.d(TAG, "onClick: $it")
    }
    val listUsers: LiveData<List<UserEntity>> = mListUsers
    val onSelectedUser: LiveData<UserEntity> = mSelectableUser

    init {
        KTP.openScopes(MainApplication.APP_NAME, this)
            .installModules(DiListPostsModule())
            .inject(this)

        disposables.add(
            interactor.loadUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mListUsers.value = it
                }, { it.printStackTrace() })
        )
    }


    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}