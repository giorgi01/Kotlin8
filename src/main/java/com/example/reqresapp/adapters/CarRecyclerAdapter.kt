package com.example.reqresapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reqresapp.R
import com.example.reqresapp.api.dto.Car
import com.squareup.picasso.Picasso

class CarRecyclerAdapter(private val cars: List<Car>): RecyclerView.Adapter<CarRecyclerAdapter.CarViewHolder>() {
    class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val nameView: TextView = itemView.findViewById(R.id.textView)
        private val yearView: TextView = itemView.findViewById(R.id.textView2)

        fun onBind(car: Car){
            Picasso.get().load("https://i.imgur.com/pK6EcGx.jpeg").into(image)
            nameView.text = car.name
            yearView.text = car.year.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(cars[position])
    }

    override fun getItemCount(): Int {
        return cars.size
    }
}