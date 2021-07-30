package com.example.entity

import com.squareup.moshi.Json

data class Response(

	@Json(name="totalResults")
	val totalResults: Int? = null,
	val articles: List<ArticlesItem2> = emptyList(),
	@Json(name="status")
	val status: String? = null
)


data class Source(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: String? = null
)
