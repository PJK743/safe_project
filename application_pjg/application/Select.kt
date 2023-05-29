package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Select : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select)

        val btn1: Button =findViewById(R.id.btn1)
        val btn2: Button =findViewById(R.id.btn2)
        val btn3: Button =findViewById(R.id.btn3)
        val btn4: Button =findViewById(R.id.btn4)
        val btn5: Button =findViewById(R.id.btn5)
        val btn6: Button =findViewById(R.id.btn6)

        btn1.setOnClickListener {
            val intent = Intent(this, Flame::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, Buzzer::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, Gas::class.java)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            val intent = Intent(this, Led::class.java)
            startActivity(intent)
        }
        btn5.setOnClickListener {
            val intent = Intent(this, Light::class.java)
            startActivity(intent)
        }
        btn6.setOnClickListener {
            val intent = Intent(this, TempHm::class.java)
            startActivity(intent)
        }


    }
}

