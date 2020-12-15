package com.bhupen.jsonapidemo.domain.usecase

import com.bhupen.jsonapidemo.domain.repository.Repository


class FilterUsersByName(
    private val repository: Repository
) {
    suspend fun invoke(name:String) = repository.getUsersByName(name)
}