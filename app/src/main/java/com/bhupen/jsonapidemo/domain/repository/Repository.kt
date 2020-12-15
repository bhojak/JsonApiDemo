package com.bhupen.jsonapidemo.domain.repository

import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.model.User
import com.bhupen.jsonapidemo.domain.model.UserWithPosts

interface Repository {
    suspend fun getUsers(): ResultData<List<User>>
    suspend fun getUsersByName(name: String): ResultData<List<User>>
    suspend fun getUserWithPosts(userId: Int): ResultData<UserWithPosts>
}