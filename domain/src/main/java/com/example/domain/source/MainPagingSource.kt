package com.example.domain.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.MainRepository
import com.example.entity.ArticlesItem
import com.example.entity.ResultState
import kotlinx.coroutines.flow.collect

class MainPagingSource(private val repository: MainRepository) : PagingSource<Int, ArticlesItem>() {


    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ArticlesItem> {
        return try {
            val mutableList = mutableListOf<ArticlesItem>()
            val nextPageNumber = params.key ?: 1
//            val PrevPageNumber = if (nextPageNumber == 1) null else nextPageNumber - 1
            val repository = repository.getListPaging(nextPageNumber)
            var isstop: Boolean = false
            var throwable = Throwable()

            repository.collect { allNowPlayingItem ->
                when (allNowPlayingItem) {
                    is ResultState.Success -> {
                        isstop = false;
                        mutableList.addAll(allNowPlayingItem.data)
                    }
                    is ResultState.Error -> {
                        isstop = true;
                        throwable = allNowPlayingItem.throwable
                    }
                    is ResultState.Empty -> {
                        isstop = true;
                    }
                }
            }

            if (isstop) {
                return LoadResult.Error(
                    throwable = throwable
                )
            }
            return LoadResult.Page(
                data = mutableList,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Throwable) {
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticlesItem>): Int? {
        return null
    }
}