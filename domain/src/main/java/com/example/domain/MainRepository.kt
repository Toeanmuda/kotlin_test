package com.example.domain

import androidx.paging.PagingSource
import com.example.entity.*
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getListPaging(page: Int): Flow<ResultState<List<ArticlesItem>>>
    suspend fun getListPaging2(page: Int): List<ArticlesItem>
    suspend fun insertAll(list: List<ArticlesItem>)
    /*fun getAllDAta():PagingSource<Int, ArticlesItem>*/
    suspend fun clearArticle()

    suspend fun insertAllRemoteKey(remoteKey: List<RemoteKeys>)
    suspend fun remoteKeysRepoId(publishedAt: String):RemoteKeys?
    suspend fun clearRemoteKeys()
}