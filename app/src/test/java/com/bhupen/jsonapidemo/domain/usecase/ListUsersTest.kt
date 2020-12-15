package com.bhupen.jsonapidemo.domain.usecase

import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.fake.*
import com.bhupen.jsonapidemo.domain.repository.Repository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListUsersTest{
    @Mock
    lateinit var repository: Repository

    lateinit var listUsers: ListUsers

    @Before
    fun setUp() {
        listUsers = ListUsers(repository)
    }

    @Test
    fun `invoke calls repository`(){
        runBlocking {
            val users = listOf(mockedUser.copy(id = 1))
            whenever(repository.getUsers()).thenReturn(ResultData.Success(users))
            when (val result = listUsers.invoke()){
                is ResultData.Success ->{
                    assertEquals(users, result.data)
                }
            }
        }
    }

    @Test
    fun `invoke calls repository error`(){
        runBlocking {
            val error = mockedErrorUserList
            whenever(repository.getUsers()).thenReturn(ResultData.Error(error))
            when (val result = listUsers.invoke()){
                is ResultData.Error ->{
                    assertEquals(error, result.exception)
                }
            }
        }
    }
}