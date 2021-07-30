package com.example.data

import com.example.data.local.InventoryRoomDatabase
import com.example.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val inventoryRoomDatabase: InventoryRoomDatabase
) :
    com.example.domain.MainRepository {

    override fun getListPaging(page: Int): Flow<ResultState<List<ArticlesItem>>> = flow {
        try {
            val response = apiService.getListPaging(page)
            if (response.articles.isNotEmpty()) {
                emit(ResultState.Success(response.articles))
            } else {
                emit(ResultState.Empty)
            }

        } catch (throwable: Throwable) {
            emit(ResultState.Error(throwable))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getListPaging2(page: Int): List<ArticlesItem> {
       return apiService.getListPaging(page).articles
    }

    override suspend fun insertAll(list: List<ArticlesItem>) {
        inventoryRoomDatabase.inventoryDao().insertAll(list)
    }

/*
    override fun getAllDAta(): PagingSource<Int, ArticlesItem> {
        return inventoryRoomDatabase.inventoryDao().getAllDAta()
    }
*/

    override suspend fun clearArticle() {
        inventoryRoomDatabase.inventoryDao().clearArticle()
    }

    override suspend fun insertAllRemoteKey(remoteKey: List<RemoteKeys>) {
        inventoryRoomDatabase.remotekeyDao().insertAll(remoteKey)
    }

    override suspend fun remoteKeysRepoId(publishedAt: String): RemoteKeys {
        return inventoryRoomDatabase.remotekeyDao().remoteKeysRepoId(publishedAt)
    }

    override suspend fun clearRemoteKeys() {
        inventoryRoomDatabase.remotekeyDao().clearRemoteKeys()
    }
/*
    override fun inventoryRoomDatabase(): InventoryRoomDatabase {
        return inventoryRoomDatabase
    }

    override fun service(): ApiService {
        return apiService
    }*/


}