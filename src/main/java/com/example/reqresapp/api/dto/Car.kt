package com.example.reqresapp.api.dto

import com.google.gson.annotations.SerializedName

data class ReqResData<T>(
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val data: T?
)

data class Car (
    val id: Long?,
    val name: String?,
    val year: Int,
    val avatar: String?,
)