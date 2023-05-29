package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Main : AppCompatActivity() {
    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        // 로그인 버튼
        val btn_login: Button = findViewById(R.id.btn_login)


        btn_login.setOnClickListener {

            //editText로부터 입력된 값을 받아온다

            val edit_id = findViewById<EditText>(R.id.edit_id)
            val edit_pw = findViewById<EditText>(R.id.edit_pw)

            var id = edit_id.text.toString()
            var pw = edit_pw.text.toString()

            // 쉐어드로부터 저장된 id, pw 가져오기
            val sharedPreference = getSharedPreferences("file name", MODE_PRIVATE)
            val savedId = sharedPreference.getString("id", "")
            val savedPw = sharedPreference.getString("pw", "")

            // 유저가 입력한 id, pw값과 쉐어드로 불러온 id, pw값 비교
            if(id == savedId && pw == savedPw){
                // 로그인 성공 다이얼로그 보여주기
                dialog("success")
            }
            else{
                // 로그인 실패 다이얼로그 보여주기
                dialog("success")
            }
        }



    }

    // 로그인 성공/실패 시 다이얼로그를 띄워주는 메소드
    fun dialog(type: String){
        var dialog = AlertDialog.Builder(this)

        if(type == "success"){
            dialog.setTitle("로그인 성공")
            dialog.setMessage("로그인 성공!")
        }
        else if(type == "fail"){
            dialog.setTitle("로그인 실패")
            dialog.setMessage("아이디와 비밀번호를 확인해주세요")
        }

        var dialog_listener = DialogInterface.OnClickListener { dialog, which ->
            when(which){
                DialogInterface.BUTTON_POSITIVE ->
                {

                    val intent = Intent(this, Select::class.java)
                    startActivity(intent)
                }

            }

        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }
}