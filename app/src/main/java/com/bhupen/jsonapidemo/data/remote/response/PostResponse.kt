package com.bhupen.jsonapidemo.data.remote.response

data class PostResponse(
    val id:Int,
    val userId: Int,
    val title: String,
    val body: String
)