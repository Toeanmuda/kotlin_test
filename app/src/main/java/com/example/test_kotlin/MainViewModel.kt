package com.example.test_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.MainUseCase
import com.example.entity.ArticlesItem2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : ViewModel() {

    val getListPaging: LiveData<PagingData<ArticlesItem2>> =
        mainUseCase.getListPaging().asLiveData().cachedIn(viewModelScope)

    val getListPagingOfflinEOnline: Flow<PagingData<ArticlesItem2>> =
        mainUseCase.getListPagingOfflinE_Online()
}