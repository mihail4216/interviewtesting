package com.misendem.interviewproject.data.di.features

import com.misendem.interviewproject.data.repository.IUsersRepository
import com.misendem.interviewproject.data.repositoryImpl.UsersRepository
import com.misendem.interviewproject.domain.interactors.ListUserInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ListUsersModule {

    @ViewModelScoped
    @Binds
    abstract fun bindsRepository(usersRepository: UsersRepository): IUsersRepository

    @Module
    @InstallIn(ViewModelComponent::class)
    object Modules {
        @ViewModelScoped
        @Provides
        fun provideInteractor(rep: IUsersRepository): ListUserInteractor {
            return ListUserInteractor(rep)
        }
    }
}