package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class coursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        var btngo=findViewById<Button>(R.id.btngo)
        btngo.setOnClickListener {
            var intent=Intent(baseContext,loginActivity::class.java)
            startActivity(intent)
        }
    }
}