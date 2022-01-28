package com.example.chucknorrisapp.network.data

import com.squareup.moshi.Json

data class ChuckNorrisRsponse(
    val category:List<String>?,
    @Json(name = "created_at") val createdAt:String,
    @Json(name = "id") val id:String,
    @Json(name = "updated_at") val updatedAt:String,
    val value: String
)
