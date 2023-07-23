package com.example.diciointerviewapp.remote

import com.example.diciointerviewapp.remote.responses.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApi {
    @GET("user")
    suspend fun getUserList(@Header("xc-token") token: String): User

    @POST("/")
    suspend fun addNewUser(@Header("xc-token") token: String, @Body request: User): Call<User>
}