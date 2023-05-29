package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SensorDataListAdapter5(private val sensorList: ArrayList<LightData>) : RecyclerView.Adapter<SensorDataListAdapter5.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ID: TextView = itemView.findViewById(R.id.ID)
        val vest_num: TextView = itemView.findViewById(R.id.vest_num)
        val Light: TextView = itemView.findViewById(R.id.Light)
        val LightTime: TextView = itemView.findViewById(R.id.LightTime)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sensor_item5, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = sensorList[position]

        holder.ID.text = "아이디 : ${data.ID}"
        holder.vest_num.text = "조끼번호 : ${data.vest_num}"
        holder.Light.text = "밝기 : ${data.Light}"
        holder.LightTime.text = "날짜 : ${data.LightTime}"


    }


    override fun getItemCount(): Int {
        return sensorList.size
    }

    fun updateData(dataList: List<LightData>) {
        sensorList.clear()
        sensorList.addAll(dataList)
        notifyDataSetChanged()
    }
}