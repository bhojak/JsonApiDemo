package com.bhupen.jsonapidemo.domain.fake

import com.bhupen.jsonapidemo.domain.model.Post
import com.bhupen.jsonapidemo.domain.model.User

val mockedUserId = 0

val mockedPost = Post(0,0,"titulo","body")
val mockedUser = User(0, "Michael", "lol@lol.com", "3212200402")

val mockedUserIdError = 159
val mockedErrorUserWithPosts = "Usuario no existe"

val mockedErrorUserList = "No se pudo traer la data"

val mockedName = "Mi"