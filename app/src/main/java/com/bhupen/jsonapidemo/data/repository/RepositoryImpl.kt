package com.bhupen.jsonapidemo.data.repository

import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.model.User
import com.bhupen.jsonapidemo.domain.model.UserWithPosts
import com.bhupen.jsonapidemo.domain.repository.Repository


class RepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): Repository {
    override suspend fun getUsers(): ResultData<List<User>> {
        if (localDataSource.isEmptyUsers()){
            when (val result = remoteDataSource.getUsers()) {
                is ResultData.Success -> localDataSource.insertUsers(result.data)
                is ResultData.Error -> return result
            }
        }
        return localDataSource.getUsers()
    }

    override suspend fun getUsersByName(name: String): ResultData<List<User>> {
        return localDataSource.searchUsersByName(name)
    }

    override suspend fun getUserWithPosts(userId: Int): ResultData<UserWithPosts> {
        if (localDataSource.isEmptyPosts(userId)){
            when (val result = remoteDataSource.getPostByUserId(userId)) {

                is ResultData.Success -> {
                    localDataSource.insertPosts(result.data)
                }
                is ResultData.Error -> {
                    return result
                }
            }
        }
        return localDataSource.getPostByUserId(userId)
    }

}