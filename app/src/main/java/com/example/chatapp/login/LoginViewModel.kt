package com.example.chatapp.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.model.User
import com.example.chatapp.repository.UserRepository

class LoginViewModel : ViewModel(){
    private var listUser = MutableLiveData<ArrayList<User>>()
    private var userRepository : UserRepository? = null
    fun getListUser() : MutableLiveData<ArrayList<User>> {
        listUser = MutableLiveData()
        userRepository = UserRepository()
        loadData()
        return listUser
    }

    private fun loadData() {
        userRepository!!.getUserLiveData().observeForever{
            if(it != null && it.isNotEmpty()){
                listUser.value = it
            }
        }
        userRepository!!.getAllUser()
    }
}