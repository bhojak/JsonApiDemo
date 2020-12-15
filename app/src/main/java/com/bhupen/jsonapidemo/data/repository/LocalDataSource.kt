package com.bhupen.jsonapidemo.data.repository

import com.bhupen.jsonapidemo.data.remote.response.PostResponse
import com.bhupen.jsonapidemo.data.remote.response.UserResponse
import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.model.User
import com.bhupen.jsonapidemo.domain.model.UserWithPosts

interface LocalDataSource {
    suspend fun getUsers(): ResultData<List<User>>
    suspend fun isEmptyUsers(): Boolean
    suspend fun isEmptyPosts(userId: Int): Boolean
    suspend fun insertUsers(users: List<UserResponse>)
    suspend fun getPostByUserId(userId: Int): ResultData<UserWithPosts>
    suspend fun insertPosts(posts: List<PostResponse>)
    suspend fun searchUsersByName(name: String): ResultData<List<User>>
}