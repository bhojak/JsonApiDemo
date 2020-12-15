package com.bhupen.jsonapidemo.domain.usecase


import com.bhupen.jsonapidemo.data.local.model.UserWithPostsEntity
import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.fake.*
import com.bhupen.jsonapidemo.domain.repository.Repository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SeeUserPostsTest {

    @Mock
    lateinit var repository: Repository

    lateinit var seeUserPosts: SeeUserPosts

    @Before
    fun setUp() {
        seeUserPosts = SeeUserPosts(repository)
    }


    @Test
    fun `invoke calls repository error`(){
        runBlocking {
            val error = mockedErrorUserWithPosts
            val userId = mockedUserIdError
            whenever(repository.getUserWithPosts(userId)).thenReturn(ResultData.Error(error))
            when (val result = seeUserPosts.invoke(userId)){
                is ResultData.Error ->{
                    Assert.assertEquals(error, result.exception)
                }
            }
        }
    }
}