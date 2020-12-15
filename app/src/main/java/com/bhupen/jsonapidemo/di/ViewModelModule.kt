package com.bhupen.jsonapidemo.di

import androidx.hilt.Assisted
import com.bhupen.jsonapidemo.domain.usecase.FilterUsersByName
import com.bhupen.jsonapidemo.domain.usecase.ListUsers
import com.bhupen.jsonapidemo.domain.usecase.SeeUserPosts
import com.bhupen.jsonapidemo.ui.main.MainViewModel
import com.bhupen.jsonapidemo.ui.post.PostViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class ViewModelModule {

    @Provides
    fun providesMainViewModel(
        listUsers: ListUsers,
        filterUsersByName: FilterUsersByName
    ) = MainViewModel(listUsers, filterUsersByName)

    @Provides
    fun providesPostViewModel(
        seeUserPosts: SeeUserPosts
    ) = PostViewModel(seeUserPosts)


}