package com.example.domain

import androidx.paging.PagingSource
import com.example.entity.*
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getListPaging(page: Int): Flow<ResultState<List<ArticlesItem2>>>
    suspend fun getListPaging2(page: Int): List<ArticlesItem2>
    suspend fun insertAll(list: List<ArticlesItem2>)
    fun getAllDAta():PagingSource<Int, ArticlesItem2>
    suspend fun clearArticle()

    suspend fun insertAllRemoteKey(remoteKey: List<RemoteKeys>)
    suspend fun remoteKeysRepoId(publishedAt: String):RemoteKeys?
    suspend fun clearRemoteKeys()
}