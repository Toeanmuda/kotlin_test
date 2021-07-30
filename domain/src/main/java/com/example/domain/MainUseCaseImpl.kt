package com.example.domain

import androidx.paging.*
import com.example.domain.source.MainPagingSource
import com.example.domain.source.MainRemoteMediator
import com.example.entity.ArticlesItem2
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(private val repository: MainRepository) : MainUseCase {

    override fun getListPaging(): Flow<PagingData<ArticlesItem2>> {
        return Pager(
            // Configure how data is loaded by passing additional properties to
            // PagingConfig, such as prefetchDistance.
            PagingConfig(pageSize = 20)
        ) {
            MainPagingSource(repository)
        }.flow
    }

    override fun getListPagingOfflinE_Online(): Flow<PagingData<ArticlesItem2>> {
        val pagingSourceFactory = { repository.getAllDAta()}

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = MainRemoteMediator(repository),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }

    /*fun getSearchResultStream(query: String): Flow<PagingData<ArticlesItem>> {

    }*/

}