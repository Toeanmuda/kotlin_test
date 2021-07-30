package com.example.data

import com.example.entity.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://newsapi.org/v2/everything
    //https://newsapi.org/v2/everything?q=tesla&apiKey=&page=2
    @GET("everything/")
    suspend fun getListPaging(
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = "c46ddfe55d8f4b3c835f04046c3fb1eb",
        @Query("q") q: String = "tesla"): Response

}