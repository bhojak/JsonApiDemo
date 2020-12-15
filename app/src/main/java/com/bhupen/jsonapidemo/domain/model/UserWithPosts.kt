package com.bhupen.jsonapidemo.domain.model

data class UserWithPosts(
    val user: User,
    val posts: List<Post>
)