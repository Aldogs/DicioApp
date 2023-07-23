package com.example.diciointerviewapp.repository

import com.example.diciointerviewapp.data.remote.UserApi
import com.example.diciointerviewapp.data.remote.responses.User
import com.example.diciointerviewapp.data.remote.responses.UserList
import com.example.diciointerviewapp.util.Constants.XC_TOKEN
import com.example.diciointerviewapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserRepository @Inject constructor(
    private val api: UserApi
){
    suspend fun getUserList(): Resource<UserList> {
        val response = try {
            api.getUserList(XC_TOKEN)
        } catch (e: Exception) {
            return Resource.Error("There was an error.")
        }
        return Resource.Success(response)
    }

    //TODO::Make function to send new user data
}