package com.bhupen.jsonapidemo.di


import com.bhupen.jsonapidemo.data.repository.LocalDataSource
import com.bhupen.jsonapidemo.data.repository.RemoteDataSource
import com.bhupen.jsonapidemo.data.repository.RepositoryImpl
import com.bhupen.jsonapidemo.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun providesRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): Repository = RepositoryImpl(localDataSource, remoteDataSource)
}