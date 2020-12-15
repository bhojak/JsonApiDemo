package com.bhupen.jsonapidemo.domain.usecase

import com.bhupen.jsonapidemo.domain.repository.Repository


class SeeUserPosts(
    private val repository: Repository
) {
    suspend fun invoke(id:Int) = repository.getUserWithPosts(id)
}