
package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SensorDataListAdapter(private val sensorList: ArrayList<FlameData>) : RecyclerView.Adapter<SensorDataListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ID: TextView = itemView.findViewById(R.id.ID)
        val vest_num: TextView = itemView.findViewById(R.id.vest_num)
        val Fire: TextView = itemView.findViewById(R.id.Fire)
        val FlameTime: TextView = itemView.findViewById(R.id.FlameTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sensor_item, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = sensorList[position]

        holder.ID.text = "아이디 : ${data.ID}"
        holder.vest_num.text = "조끼번호 : ${data.vest_num}"
        holder.Fire.text = "화염감지 : ${data.Fire}"
        holder.FlameTime.text = "날짜 : ${data.FlameTime}"


    }


    override fun getItemCount(): Int {
        return sensorList.size
    }

    fun updateData(dataList: List<FlameData>) {
        sensorList.clear()
        sensorList.addAll(dataList)
        notifyDataSetChanged()
    }
}
