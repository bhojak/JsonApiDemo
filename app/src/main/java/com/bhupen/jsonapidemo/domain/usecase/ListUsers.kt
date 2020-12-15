package com.bhupen.jsonapidemo.domain.usecase

import com.bhupen.jsonapidemo.domain.repository.Repository

class ListUsers(
    private val repository: Repository
) {
    suspend fun invoke() = repository.getUsers()
}