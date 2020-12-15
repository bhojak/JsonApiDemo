package com.bhupen.jsonapidemo.domain.usecase

import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.fake.mockedName
import com.bhupen.jsonapidemo.domain.fake.mockedUser
import com.bhupen.jsonapidemo.domain.repository.Repository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilterUsersByNameTest {
    @Mock
    lateinit var repository: Repository

    lateinit var filterUsersByName: FilterUsersByName

    @Before
    fun setUp() {
        filterUsersByName = FilterUsersByName(repository)
    }

    @Test
    fun `invoke calls repository`(){
        runBlocking {
            val users = listOf(mockedUser.copy(id = 1))
            val name = mockedName
            whenever(repository.getUsersByName(name)).thenReturn(ResultData.Success(users))
            when (val result = filterUsersByName.invoke(name)){
                is ResultData.Success ->{
                    assertEquals(users, result.data)
                }
            }
        }
    }
}