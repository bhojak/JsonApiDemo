package com.bhupen.jsonapidemo.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    val id:Int,
    val name:String,
    val email:String,
    val phone:String,
) {
}