package com.bhupen.jsonapidemo.ui.post

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhupen.jsonapidemo.domain.ResultData
import com.bhupen.jsonapidemo.domain.model.Post
import com.bhupen.jsonapidemo.domain.model.User
import com.bhupen.jsonapidemo.domain.usecase.SeeUserPosts
import kotlinx.coroutines.launch

class PostViewModel @ViewModelInject constructor(
    private val seeUserPosts: SeeUserPosts
) : ViewModel(){

    val posts : LiveData<List<Post>>
        get()= _posts
    private val _posts = MutableLiveData<List<Post>>()

    val user : LiveData<User>
        get()= _user
    private val _user = MutableLiveData<User>()

    val error : LiveData<String>
        get()= _error
    private val _error = MutableLiveData<String>()

    fun fetchUserWithPosts(id:Int){
        viewModelScope.launch {
            when (val userwithPosts = seeUserPosts.invoke(id)){
                is ResultData.Success -> {
                    _posts.value = userwithPosts.data.posts
                    _user.value = userwithPosts.data.user
                }
                is ResultData.Error -> {
                    _error.value = userwithPosts.exception
                }
            }
        }
    }

}