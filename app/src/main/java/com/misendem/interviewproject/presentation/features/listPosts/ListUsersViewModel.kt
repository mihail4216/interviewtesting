package com.misendem.interviewproject.presentation.features.listPosts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misendem.interviewproject.MainApplication
import com.misendem.interviewproject.data.entity.UserEntity
import com.misendem.interviewproject.domain.interactors.ListPostsInteractor
import com.misendem.interviewproject.presentation.extension.TAG
import com.misendem.interviewproject.presentation.features.listPosts.di.DiListPostsModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import toothpick.ktp.KTP
import javax.inject.Inject

class ListUsersViewModel : ViewModel() {

    @Inject
    lateinit var interactor: ListPostsInteractor

    private val disposables = CompositeDisposable()
    val onClickItem: (UserEntity) -> Unit = {
        Log.d(TAG, "onClick: $it")
    }
    val listUsers = MutableLiveData<List<UserEntity>>()

    init {
        KTP.openScopes(MainApplication.APP_NAME, this)
            .installModules(DiListPostsModule())
            .inject(this)

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