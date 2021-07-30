package com.example.test_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.MainUseCase
import com.example.entity.ArticlesItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : ViewModel() {

    val getListPaging: LiveData<PagingData<ArticlesItem>> =
        mainUseCase.getListPaging().asLiveData().cachedIn(viewModelScope)
}