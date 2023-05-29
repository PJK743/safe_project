package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SensorDataListAdapter6(private val sensorList: ArrayList<TempHmData>) : RecyclerView.Adapter<SensorDataListAdapter6.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ID: TextView = itemView.findViewById(R.id.ID)
        val vest_num: TextView = itemView.findViewById(R.id.vest_num)
        val Temp: TextView = itemView.findViewById(R.id.Temp)
        val Hm: TextView = itemView.findViewById(R.id.Hm)
        val TempHmTime: TextView = itemView.findViewById(R.id.TempHmTime)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sensor_item6, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = sensorList[position]

        holder.ID.text = "아이디 : ${data.ID}"
        holder.vest_num.text = "조끼번호 : ${data.vest_num}"
        holder.Temp.text = "온도 : ${data.Temp}"
        holder.Hm.text = "습도 : ${data.Hm}"
        holder.TempHmTime.text = "날짜 : ${data.TempHmTime}"


    }


    override fun getItemCount(): Int {
        return sensorList.size
    }

    fun updateData(dataList: List<TempHmData>) {
        sensorList.clear()
        sensorList.addAll(dataList)
        notifyDataSetChanged()
    }
}