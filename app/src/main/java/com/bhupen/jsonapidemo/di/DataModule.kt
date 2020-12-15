package com.bhupen.jsonapidemo.di

import android.content.Context
import com.bhupen.jsonapidemo.data.local.JsonApiDB
import com.bhupen.jsonapidemo.data.local.RoomDataSource
import com.bhupen.jsonapidemo.data.remote.RemoteApiDataSource
import com.bhupen.jsonapidemo.data.remote.api.ApiService
import com.bhupen.jsonapidemo.data.repository.LocalDataSource
import com.bhupen.jsonapidemo.data.repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun providesApi() : RemoteDataSource {
        val retrofit =Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)
        return RemoteApiDataSource(api)

    }

    @Singleton
    @Provides
    fun provideRoomDataSource(@ApplicationContext appContext: Context) : LocalDataSource {
        val db = JsonApiDB.build(appContext).dao
        return RoomDataSource(db)
    }

}