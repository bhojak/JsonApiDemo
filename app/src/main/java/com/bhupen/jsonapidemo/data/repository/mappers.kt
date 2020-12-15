package com.bhupen.jsonapidemo.data.repository

import com.bhupen.jsonapidemo.data.local.entity.PostEntity
import com.bhupen.jsonapidemo.data.local.entity.UserEntity
import com.bhupen.jsonapidemo.data.local.model.UserWithPostsEntity
import com.bhupen.jsonapidemo.data.remote.response.PostResponse
import com.bhupen.jsonapidemo.data.remote.response.UserResponse
import com.bhupen.jsonapidemo.domain.model.Post
import com.bhupen.jsonapidemo.domain.model.User
import com.bhupen.jsonapidemo.domain.model.UserWithPosts

fun UserEntity.toDomain(): User =
    User(
        id = id,
        name = name,
        email = email,
        phone = phone
    )

fun UserResponse.toLocal(): UserEntity =
    UserEntity(
        id = id,
        name = name,
        email = email,
        phone = phone
    )

fun PostEntity.toDomain(): Post =
    Post(
        id = id,
        userId = userId,
        title = title,
        body = body
    )

fun PostResponse.toLocal(): PostEntity =
    PostEntity(
        id = id,
        userId = userId,
        title = title,
        body = body
    )

fun UserWithPostsEntity.toDomain(): UserWithPosts =
    UserWithPosts(
        user = user.toDomain(),
        posts = posts.map { it.toDomain() }
    )