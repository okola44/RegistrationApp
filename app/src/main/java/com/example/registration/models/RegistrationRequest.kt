package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    var name:String,
    var email=String,
    @SerializedName("phone_number") phoneNumber:String,
    @SerializedName("date_of_birth") dateOfBirth:String,
    var nationality:String,
    var password:String,
)
