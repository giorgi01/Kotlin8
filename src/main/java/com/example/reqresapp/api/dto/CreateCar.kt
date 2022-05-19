package com.example.reqresapp.api.dto

import java.util.Date

data class CreateCarCommand (
    val name: String,
    val year: String,
)

data class CreateCarResponse (
    val id : String,
    val name: String,
    val year: String,
)