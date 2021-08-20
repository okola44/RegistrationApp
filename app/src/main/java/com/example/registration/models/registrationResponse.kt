package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class registrationResponse(
    var name:String,
    var email=String,
    @SerializedName("phone_number") var phoneNumber:String,
    @SerializedName("date_of_birth") var dateOfBirth:String,
    var nationality:String,
    @SerializedName("student_id")var studentId:String,

)
