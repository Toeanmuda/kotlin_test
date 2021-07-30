package com.example.data.local

import androidx.paging.PagingSource
import androidx.room.*
import com.example.entity.ArticlesItem2

@Dao
interface InventoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<ArticlesItem2>)

    @Query("SELECT * FROM ArticlesItem")
    fun getAllDAta(): PagingSource<Int, ArticlesItem2>


    @Query("DELETE FROM ArticlesItem")
    suspend fun clearArticle()
}