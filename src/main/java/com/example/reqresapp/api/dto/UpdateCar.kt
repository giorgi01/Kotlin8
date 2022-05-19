package com.example.reqresapp.api.dto

import java.util.Date

data class UpdateCarCommand (
    val name: String,
    val year: String
)

data class UpdateCarResponse (
    val id: String,
    val name: String,
    val year: String,
)