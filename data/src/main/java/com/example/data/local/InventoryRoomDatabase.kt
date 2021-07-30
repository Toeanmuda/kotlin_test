package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.entity.ArticlesItem2
import com.example.entity.RemoteKeys


@Database(entities = [ArticlesItem2::class,RemoteKeys::class] , version = 1, exportSchema = false)
abstract class InventoryRoomDatabase : RoomDatabase() {
    abstract fun inventoryDao(): InventoryDao
    abstract fun remotekeyDao(): RemoteKeyDao
}