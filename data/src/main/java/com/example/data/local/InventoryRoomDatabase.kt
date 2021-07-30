package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.converter.Coverter
import com.example.entity.ArticlesItem
import com.example.entity.RemoteKeys

@Database(entities = [RemoteKeys::class , ArticlesItem::class], version = 1, exportSchema = false)
abstract class InventoryRoomDatabase : RoomDatabase() {
    abstract fun inventoryDao(): InventoryDao
    abstract fun remotekeyDao(): RemoteKeyDao
}