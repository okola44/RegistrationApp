package com.example.registration.Api

import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse

import retrofit2.http.POST

interface ApiInerface {
    @POST("/student/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>

    @POST("/students/register")
    fun logInStudent(@Body loginRequest:LoginRequest):Call<LoginResponse>
}