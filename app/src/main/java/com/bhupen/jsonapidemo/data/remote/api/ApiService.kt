package com.bhupen.jsonapidemo.data.remote.api

import com.bhupen.jsonapidemo.data.remote.response.PostResponse
import com.bhupen.jsonapidemo.data.remote.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{

    @GET("/users")
    suspend fun fetchPosts(): Response<List<UserResponse>>

    @GET("/posts")
    suspend fun fetchPostByUserId(@Query("userId") id:Int): Response<List<PostResponse>>
}