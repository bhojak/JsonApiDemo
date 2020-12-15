package com.bhupen.jsonapidemo.di

import com.bhupen.jsonapidemo.domain.repository.Repository
import com.bhupen.jsonapidemo.domain.usecase.FilterUsersByName
import com.bhupen.jsonapidemo.domain.usecase.ListUsers
import com.bhupen.jsonapidemo.domain.usecase.SeeUserPosts
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    fun providesFilterUserByNameList(
        repository: Repository
    ) = FilterUsersByName(repository)

    @Provides
    fun providesListUsers(
        repository: Repository
    ) = ListUsers(repository)

    @Provides
    fun providesseeUserPosts(
        repository: Repository
    ) = SeeUserPosts(repository)


}