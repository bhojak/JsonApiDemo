package com.bhupen.jsonapidemo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bhupen.jsonapidemo.data.local.dao.JsonApiDao
import com.bhupen.jsonapidemo.data.local.entity.PostEntity
import com.bhupen.jsonapidemo.data.local.entity.UserEntity

@Database(entities = [
    PostEntity::class,
    UserEntity::class
],version = 1, exportSchema = false)
abstract class JsonApiDB : RoomDatabase(){
    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            JsonApiDB::class.java,
            "json_api_db"
        ).build()
    }

    abstract val dao: JsonApiDao
}