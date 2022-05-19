package com.example.reqresapp.api.dto

import retrofit2.Call
import retrofit2.http.*

interface ReqResService {
    @GET("cars")
    fun getCars(@Query("page")page: Int): Call<ReqResData<List<Car>>>

    @GET("cars/{carId}")
    fun getCar(@Path("carId")id: Long): Call<ReqResData<Car>>

    @POST("cars")
    fun createCar(@Body car: CreateCarCommand) : Call<CreateCarResponse>

    @PUT("cars/{carId}")
    fun updateCar(@Body car: UpdateCarCommand, @Path("carId")id: Long) : Call<UpdateCarResponse>
}