package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SensorDataListAdapter3(private val sensorList: ArrayList<GasData>) : RecyclerView.Adapter<SensorDataListAdapter3.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ID: TextView = itemView.findViewById(R.id.ID)
        val vest_num: TextView = itemView.findViewById(R.id.vest_num)
        val Gas: TextView = itemView.findViewById(R.id.Gas)
        val GasTime: TextView = itemView.findViewById(R.id.GasTime)

    }

    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sensor_item3, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = sensorList[position]

        holder.ID.text = "아이디 : ${data.ID}"
        holder.vest_num.text = "조끼번호 : ${data.vest_num}"
        holder.Gas.text = "가스 : ${data.Gas}"
        holder.GasTime.text = "날짜 : ${data.GasTime}"


    }


    override fun getItemCount(): Int {
        return sensorList.size
    }

    fun updateData(dataList: List<GasData>) {
        sensorList.clear()
        sensorList.addAll(dataList)
        notifyDataSetChanged()
    }
}