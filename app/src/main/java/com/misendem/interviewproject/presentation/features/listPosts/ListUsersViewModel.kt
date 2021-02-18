package com.misendem.interviewproject.presentation.features.listPosts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.domain.interactors.ListUserInteractor
import com.misendem.interviewproject.presentation.extension.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ListUsersViewModel @Inject constructor(
    interactor: ListUserInteractor
) : ViewModel() {

    private val disposables = CompositeDisposable()
    val onClickItem: (UserEntity) -> Unit = {
        Log.d(TAG, "onClick: $it")
    }
    val listUsers = MutableLiveData<List<UserEntity>>()

    init {
        disposables.add(
            interactor.loadRepositories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    listUsers.value = it
                    Log.d(TAG, "${it.size}")
                }, { it.printStackTrace() })
        )
    }


    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}