package com.example.domain

import android.util.Log
import androidx.paging.*
import com.example.domain.source.MainPagingSource
import com.example.entity.ArticlesItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(private val repository: MainRepository) : MainUseCase {

    override fun getListPaging(): Flow<PagingData<ArticlesItem>> {
        return Pager(
            // Configure how data is loaded by passing additional properties to
            // PagingConfig, such as prefetchDistance.
            PagingConfig(pageSize = 20)
        ) {
            MainPagingSource(repository)
        }.flow
    }

    override fun getListPagingOfflinE_Online(): Flow<PagingData<ArticlesItem>> {
        /*val pagingSourceFactory = { repository.getAllDAta()}

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = MainRemoteMediator(repository),
            pagingSourceFactory = pagingSourceFactory
        ).flow*/

        return Pager(
            // Configure how data is loaded by passing additional properties to
            // PagingConfig, such as prefetchDistance.
            PagingConfig(pageSize = 20)
        ) {
            MainPagingSource(repository)
        }.flow

    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }

    /*fun getSearchResultStream(query: String): Flow<PagingData<ArticlesItem>> {

    }*/

}