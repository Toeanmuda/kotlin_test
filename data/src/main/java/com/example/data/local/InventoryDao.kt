package com.example.data.local

import androidx.paging.PagingSource
import androidx.room.*
import com.example.entity.ArticlesItem2

@Dao
interface InventoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<ArticlesItem2>)

    @Query("SELECT * FROM Articles_Item")
    fun getAllDAta(): PagingSource<Int, ArticlesItem2>


    @Query("DELETE FROM Articles_Item")
    suspend fun clearArticle()
}