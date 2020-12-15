package com.bhupen.jsonapidemo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.bhupen.jsonapidemo.data.local.entity.PostEntity
import com.bhupen.jsonapidemo.data.local.entity.UserEntity
import com.bhupen.jsonapidemo.data.local.model.UserWithPostsEntity


@Dao
interface JsonApiDao {
    @Query("SELECT * FROM userentity")
    fun getUsers(): List<UserEntity>

    @Transaction
    @Query("SELECT * FROM userentity WHERE id=:id")
    fun getUserWithPostByUserId(id:Int): UserWithPostsEntity

    @Query("SELECT COUNT(*) FROM postentity WHERE userId=:id")
    fun countPosts(id:Int): Int

    @Transaction
    @Insert
    fun insertPosts(posts: List<PostEntity>)

    @Transaction
    @Insert
    fun insertUsers(users: List<UserEntity>)

    @Query("SELECT COUNT(*) FROM userentity")
    fun countUsers(): Int

    @Query("SELECT * FROM userentity WHERE name LIKE '%'||:name||'%'")
    fun searchUsersByName(name: String): List<UserEntity>
}