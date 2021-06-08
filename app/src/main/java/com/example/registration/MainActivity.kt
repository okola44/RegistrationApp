package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etName:EditText
    lateinit var etDate:EditText
    lateinit var etIdnum:EditText
    lateinit var etNationality:EditText
    lateinit var etPhone:EditText
    lateinit var etEmail:EditText
    lateinit var btlbl:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //accessing the id names given to the edit texts in activity
        castViews()
        clickRegister()


        }


    fun castViews(){
         etName = findViewById(R.id.etName)//R.ID IS A MAPPING BTWN THE VIEW AND THE INTEGER
         etDate = findViewById(R.id.etDate)
         etIdnum = findViewById(R.id.etIdnum)
         etNationality = findViewById(R.id.etNationality)
         etPhone = findViewById(R.id.etPhone)
        etEmail = findViewById(R.id.etEmail)
        btlbl = findViewById(R.id.btlbl)

    }
    fun clickRegister() {
        btlbl.setOnClickListener {
            var name = etName.text.toString()//accessing the variable name
            //toasting
            if (name.isEmpty()) {
                etName.setError("THIS FIELD IS REQUIRED")//THROWS ERROR IF NAME IS NOT FILLED
            }
            var dob = etDate.text.toString()
            var email = etEmail.text.toString()
            var id = etIdnum.text.toString()
            var nationality = etNationality.text.toString()
            var phone = etPhone.text.toString()
            var Student = Student(name, dob, id, nationality, phone, email)
            Toast.makeText(baseContext, Student.toString(), Toast.LENGTH_LONG).show()
            val intent=Intent(baseContext,coursesActivity::class.java)
            startActivity(intent)

        }
    }
}
data class Student(var name:String,var dob:String,var id:String,var nationality:String,var phone:String,var email:String)//STORES EVERYTHING