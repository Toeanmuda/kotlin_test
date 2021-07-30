package com.example.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "ArticlesItem")
data class ArticlesItem(

    @PrimaryKey
    @Json(name="publishedAt")
    val publishedAt: String,

    @Json(name="author")
    val author: String,

    @Json(name="urlToImage")
    val urlToImage: String,

    @Json(name="description")
    val description: String,

    @Json(name="source")
    val source: Source,

    @Json(name="title")
    val title: String,

    @Json(name="url")
    val url: String,

    @Json(name="content")
    val content: Any
)