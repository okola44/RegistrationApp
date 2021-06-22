package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var etName:EditText
    lateinit var etDob:EditText
    lateinit var etIdnum:EditText
    lateinit var spNationality:Spinner
    lateinit var etPhoneNum:EditText
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
         etDob = findViewById(R.id.etDob)
         etIdnum = findViewById(R.id.etIdNum)

         etPhoneNum = findViewById(R.id.etPhoneNum)
         etEmail = findViewById(R.id.etEmail)
         btlbl = findViewById(R.id.btlbl)
        //code for  the spinner
        //select nationality is the default when you run your code
        spNationality=findViewById(R.id.spNationality)
        var nationalities= arrayOf("select Nationality","Kenyan","Rwandan","South Sudanese","Ugandan")
        var nationalityAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_item,nationalities)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter=nationalityAdapter


    }
    fun clickRegister() {
        btlbl.setOnClickListener {
            var name = etName.text.toString()//accessing the variable name
            //toasting
            if (name.isEmpty()) {
                etName.setError("THIS FIELD IS REQUIRED")//THROWS ERROR IF NAME IS NOT FILLED
            }
            var dob = etDob.text.toString()
            var email = etEmail.text.toString()
            var id = etIdnum.text.toString()
            var nationality = spNationality.selectedItem.toString()

            var phone = etPhoneNum.text.toString()
            var Student = Student(name, dob, id, nationality, phone, email)
            Toast.makeText(baseContext, Student.toString(), Toast.LENGTH_LONG).show()
            val intent=Intent(baseContext,coursesActivity::class.java)
            startActivity(intent)

        }
    }
}
//spinner set error,for now we can use a toast
//you can add a set error and error message
//android spinner change drop down icon

data class Student(var name:String,var dob:String,var id:String,var nationality:String,var phone:String,var email:String)//STORES EVERYTHING