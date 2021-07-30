package com.example.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.text.NumberFormat

data class Response(

	@Json(name="totalResults")
	val totalResults: Int? = null,

	@Json(name="articles")
	val articles: List<ArticlesItem>,

	@Json(name="status")
	val status: String? = null
)


data class Source(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: String? = null
)
