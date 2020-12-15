package com.bhupen.jsonapidemo.domain

sealed class ResultData<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultData<T>()
    data class Error(val exception: String) : ResultData<Nothing>()
}