  package com.example.reqresapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reqresapp.adapters.CarRecyclerAdapter
import com.example.reqresapp.api.dto.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

  class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        RestClient.initClient()

        RestClient.reqResApi.getCars(1).enqueue(object : Callback<ReqResData<List<Car>>> {
            override fun onResponse(
                call: Call<ReqResData<List<Car>>>,
                response: Response<ReqResData<List<Car>>>
            ) {
                if(response.isSuccessful){
                    response.body()?.data?.let {
                        recyclerView.adapter = CarRecyclerAdapter(it)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<Car>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


//        RestClient.reqResApi.getCar(1).enqueue(object : Callback<ReqResData<Car>>{
//            override fun onResponse(
//                call: Call<ReqResData<Car>>,
//                response: Response<ReqResData<Car>>
//            ) {
//                if(response.isSuccessful){
//                    response.body()?.data?.let {
////                        recyclerView.adapter = CarRecyclerAdapter()
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ReqResData<Car>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })


//        RestClient.reqResApi.createCar(CreateCarCommand("John Doe", "Developer"))
//            .enqueue(object : Callback<CreateCarResponse> {
//                override fun onResponse(
//                    call: Call<CreateCarResponse>,
//                    response: Response<CreateCarResponse>
//                ) {
//                    if(response.isSuccessful){
//                        response.body()?.id?.let { Log.d("log:", it) }
//                        response.body()?.name?.let { Log.d("log:", it) }
//                    }
//                }
//
//                override fun onFailure(call: Call<CreateCarResponse>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//
//        RestClient.reqResApi.updateCar(UpdateCarCommand("Jason Doe", "Programmer"), 1)
//            .enqueue(object: Callback<UpdateCarResponse>{
//                override fun onResponse(
//                    call: Call<UpdateCarResponse>,
//                    response: Response<UpdateCarResponse>
//                ) {
//                    response.body()?.id?.let { Log.d("log:", it) }
//                    response.body()?.name?.let { Log.d("log:", it) }
//                }
//
//                override fun onFailure(call: Call<UpdateCarResponse>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//            } )
    }
}