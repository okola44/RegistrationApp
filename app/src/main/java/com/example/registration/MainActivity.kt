package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //accessing the id names given to the edit texts in activity
        setupSpinner()
        clickRegister()


        }


    fun setupSpinner(){

        var nationalities= arrayOf("select Nationality","Kenyan","Rwandan","South Sudanese","Ugandan")
        var nationalityAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_item,nationalities)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spNationality.adapter=nationalityAdapter


    }
    fun clickRegister() {
        btlbl.setOnClickListener {
            var error=True
            var name = binding.etName.text.toString()//accessing the variable name
            //toasting
            if (name.isEmpty()) {
                binding.etName.setError("THIS FIELD IS REQUIRED")//THROWS ERROR IF NAME IS NOT FILLED
            }
            var dob = binding.etDob.text.toString()
            var email = binding.etEmail.text.toString()
            var id = binding.etIdnum.text.toString()
            var nationality = binding.spNationality.selectedItem.toString()

            var phone = binding.etPhoneNum.text.toString()
            var Student = Student(name, dob, id, nationality, phone, email)
            Toast.makeText(baseContext, Student.toString(), Toast.LENGTH_LONG).show()
            val intent=Intent(baseContext,coursesActivity::class.java)
            startActivity(intent)

            if(!error){
                binding.pbRegistration.visibility = View.VISIBLE
                var request = ReistrationRequest(name=name,dateOfBirth=dateOfBirth,email=email
                ,dateOfBirth=dateOfBirth,nationality=nationality,password=password)
                val intent=Intent(baseContext,CoursesActivity::class.java)
                startActivity(intent)
                var retrofit= buildApiClient(ApiInterface::class.java)
                val request=retrofit.registerStudent(regRequest)
                request.enqueue(object: Callback<RegistrationResponse>{
                    override fun onResponse(
                        call: Call<RegistrationResponse>,
                        response: Response<RegistrationResponse>
                    ) {
                        binding.pbRegistration.visibility=View.VISIBLE
                        if (response.isSuccessful){
                            Toast.makeText(baseContext,"Registration successful",Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                        Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                        binding.pbRegistration.visibility=View.GONE
                    }
                })

            }

        }
    }
}
            }

        }
    }
}

//spinner set error,for now we can use a toast
//you can add a set error and error message
//android spinner change drop down icon

data class Student(var name:String,var dob:String,var id:String,var nationality:String,var phone:String,var email:String)
data class Student(var name:String,var dob:String,var id:String,var nationality:String,var phone:String,var email:String)//STORES EVERYTHING