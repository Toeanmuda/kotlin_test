package com.example.domain

import androidx.paging.PagingData
import com.example.entity.ArticlesItem2
import kotlinx.coroutines.flow.Flow

interface MainUseCase {
    fun getListPaging(): Flow<PagingData<ArticlesItem2>>
    fun getListPagingOfflinE_Online(): Flow<PagingData<ArticlesItem2>>
}