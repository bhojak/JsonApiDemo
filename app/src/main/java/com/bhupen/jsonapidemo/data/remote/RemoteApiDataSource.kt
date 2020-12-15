package com.bhupen.jsonapidemo.data.remote

import com.bhupen.jsonapidemo.data.remote.api.ApiService
import com.bhupen.jsonapidemo.data.remote.response.PostResponse
import com.bhupen.jsonapidemo.data.remote.response.UserResponse
import com.bhupen.jsonapidemo.data.repository.RemoteDataSource
import com.bhupen.jsonapidemo.domain.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RemoteApiDataSource(private val apiService: ApiService): RemoteDataSource {

    override suspend fun getUsers(): ResultData<List<UserResponse>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = apiService.fetchPosts()
            val users = response.body()
            users?.let {
                ResultData.Success(it)
            } ?: run {
                ResultData.Error(response.errorBody().toString())
            }
        }catch (e: Exception){
            ResultData.Error(e.toString())
        }
    }

    override suspend fun getPostByUserId(userId: Int): ResultData<List<PostResponse>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = apiService.fetchPostByUserId(userId)
            val users = response.body()
            users?.let {
                ResultData.Success(it)
            } ?: run {
                ResultData.Error(response.errorBody().toString())
            }
        }catch (e: Exception){
            ResultData.Error(e.toString())
        }
    }

}