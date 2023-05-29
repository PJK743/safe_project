package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SensorDataListAdapter2(private val sensorList: ArrayList<BuzzerData>) : RecyclerView.Adapter<SensorDataListAdapter2.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ID: TextView = itemView.findViewById(R.id.ID)
        val vest_num: TextView = itemView.findViewById(R.id.vest_num)
        val Buz: TextView = itemView.findViewById(R.id.Buz)
        val BuzReason: TextView = itemView.findViewById(R.id.BuzReason)
        val BuzTime: TextView = itemView.findViewById(R.id.BuzTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sensor_item2, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = sensorList[position]

        holder.ID.text = "아이디 : ${data.ID}"
        holder.vest_num.text = "조끼번호 : ${data.vest_num}"
        holder.Buz.text = "부저 : ${data.Buz}"
        holder.BuzReason.text = "원인 : ${data.BuzReason}"
        holder.BuzTime.text = "날짜 : ${data.BuzTime}"


    }


    override fun getItemCount(): Int {
        return sensorList.size
    }

    fun updateData(dataList: List<BuzzerData>) {
        sensorList.clear()
        sensorList.addAll(dataList)
        notifyDataSetChanged()
    }
}