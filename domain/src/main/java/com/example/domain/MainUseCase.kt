package com.example.domain

import androidx.paging.PagingData
import com.example.entity.ArticlesItem
import kotlinx.coroutines.flow.Flow

interface MainUseCase {
    fun getListPaging(): Flow<PagingData<ArticlesItem>>
    fun getListPagingOfflinE_Online(): Flow<PagingData<ArticlesItem>>
}