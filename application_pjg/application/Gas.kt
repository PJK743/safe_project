package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Gas : AppCompatActivity() {

    lateinit var sensorAdapter: SensorDataListAdapter3
    lateinit var dataList: ArrayList<GasData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gas)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView3)
        dataList = ArrayList()

        val layoutManager = LinearLayoutManager(baseContext)
        recyclerView.layoutManager = layoutManager

        sensorAdapter = SensorDataListAdapter3(dataList)
        recyclerView.adapter = sensorAdapter


        getAPI()
    }


    private fun getAPI() {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://43.200.181.60:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val apiService = retrofit.create(Apiservice3::class.java)

        apiService.getGasData().enqueue(object : Callback<Map<String, Any>> {
            override fun onFailure(call: Call<Map<String, Any>>, t: Throwable) {
                Log.d("API 호출 실패", t.message.toString())
            }

            override fun onResponse(
                call: Call<Map<String, Any>>,
                response: Response<Map<String, Any>>
            ) {
                if (response.isSuccessful) {
                    Log.d("성공", response.body().toString())
                    val dataMap = response.body()
                    if (dataMap != null) {
                        val value1 = dataMap["0"] as? Int?:1
                        val value2 = dataMap["1"] as? String ?: ""
                        val value3 = dataMap["2"] as? String ?: ""
                        val value4 = dataMap["3"] as? String ?: ""







                        dataList.add(GasData(value1, value2, value3, value4))



                        sensorAdapter.notifyDataSetChanged()
                    }
                } else {
                    Log.d("API 응답 실패", "${response.code()} ${response.message()}")
                }
            }
        })
    }
}