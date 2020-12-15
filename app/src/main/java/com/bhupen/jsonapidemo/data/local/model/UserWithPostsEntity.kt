package com.bhupen.jsonapidemo.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.bhupen.jsonapidemo.data.local.entity.PostEntity
import com.bhupen.jsonapidemo.data.local.entity.UserEntity


data class UserWithPostsEntity(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val posts: List<PostEntity>
)