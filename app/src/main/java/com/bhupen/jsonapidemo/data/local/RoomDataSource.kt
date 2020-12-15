package com.bhupen.jsonapidemo.data.local

import com.bhupen.jsonapidemo.data.local.dao.JsonApiDao
import com.bhupen.jsonapidemo.data.remote.response.PostResponse
import com.bhupen.jsonapidemo.data.remote.response.UserResponse
import com.bhupen.jsonapidemo.data.repository.LocalDataSource
import com.bhupen.jsonapidemo.data.repository.toDomain
import com.bhupen.jsonapidemo.data.repository.toLocal
import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.model.User
import com.bhupen.jsonapidemo.domain.model.UserWithPosts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(private val dao: JsonApiDao): LocalDataSource {

    override suspend fun getUsers(): ResultData<List<User>> = withContext(Dispatchers.IO) {
        return@withContext ResultData.Success(dao.getUsers().map { it.toDomain() })
    }

    override suspend fun isEmptyUsers(): Boolean  = withContext(Dispatchers.IO) {
        return@withContext dao.countUsers() <= 0
    }

    override suspend fun isEmptyPosts(userId: Int): Boolean = withContext(Dispatchers.IO)  {
        return@withContext dao.countPosts(userId) <= 0
    }

    override suspend fun insertUsers(users: List<UserResponse>) = withContext(Dispatchers.IO) {
        dao.insertUsers(users.map { it.toLocal() })
    }

    override suspend fun getPostByUserId(userId: Int): ResultData<UserWithPosts> = withContext(Dispatchers.IO) {
        return@withContext ResultData.Success(dao.getUserWithPostByUserId(userId).toDomain())
    }

    override suspend fun insertPosts(posts: List<PostResponse>) = withContext(Dispatchers.IO) {
        dao.insertPosts(posts.map { it.toLocal() })
    }

    override suspend fun searchUsersByName(name: String): ResultData<List<User>>  = withContext(Dispatchers.IO) {
        return@withContext ResultData.Success(dao.searchUsersByName(name).map { it.toDomain() })
    }


}