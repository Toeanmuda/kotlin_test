package com.example.data.local

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.*
import com.example.entity.ArticlesItem
import com.example.entity.RemoteKeys

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM remote_keys WHERE publishedAt = :publishedAt")
    suspend fun remoteKeysRepoId(publishedAt: String): RemoteKeys

    @Query("DELETE FROM remote_keys")
    suspend fun clearRemoteKeys()
}