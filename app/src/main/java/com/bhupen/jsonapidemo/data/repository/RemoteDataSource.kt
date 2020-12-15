package com.bhupen.jsonapidemo.data.repository

import com.bhupen.jsonapidemo.data.remote.response.PostResponse
import com.bhupen.jsonapidemo.data.remote.response.UserResponse
import com.bhupen.jsonapidemo.domain.ResultData

interface RemoteDataSource {
    suspend fun getUsers(): ResultData<List<UserResponse>>
    suspend fun getPostByUserId(userId: Int): ResultData<List<PostResponse>>
}