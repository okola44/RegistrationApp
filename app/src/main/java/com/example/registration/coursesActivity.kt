package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class coursesActivity : AppCompatActivity() {
    lateinit var btngo:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        castViews2()
        clickRegister2()
        }
        fun castViews2(){
             btngo=findViewById(R.id.btngo)

        }
        fun clickRegister2(){
            btngo.setOnClickListener {
                var intent=Intent(baseContext,loginActivity::class.java)
                startActivity(intent)

        }
    }
}