package com.example.data.local

import androidx.room.*
import com.example.entity.ArticlesItem

@Dao
interface InventoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<ArticlesItem>)

    @Query("DELETE FROM ArticlesItem")
    suspend fun clearArticle()
}