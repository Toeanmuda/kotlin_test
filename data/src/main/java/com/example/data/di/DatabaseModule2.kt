package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.InventoryDao
import com.example.data.local.InventoryRoomDatabase
import com.example.data.local.RemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule2 {

    @Singleton // untuk sekali instance
    @Provides  // untuk khusus inject library
    fun provideDatabase(@ApplicationContext context: Context): InventoryRoomDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("cpn".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(context, InventoryRoomDatabase::class.java, "item_database")
            .openHelperFactory(factory)
            .build()}


    @Singleton // untuk sekali instance
    @Provides  // untuk khusus inject library
    fun provideInventoryDao(database: InventoryRoomDatabase): InventoryDao = database.inventoryDao()


    @Singleton // untuk sekali instance
    @Provides  // untuk khusus inject library
    fun provideRemoteKeyDao(database: InventoryRoomDatabase): RemoteKeyDao = database.remotekeyDao()
}