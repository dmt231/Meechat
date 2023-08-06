package com.example.chatapp.storage

import android.content.Context
import android.content.SharedPreferences


class Preferences {
    private val myPreferences : String = "MyPreferences"
    private val context : Context
    constructor(context: Context){
        this.context = context
    }
    fun putStatusValues(status : String){
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString("Status", status)
        editor.apply()
    }
    fun getStatusValues() : String? {
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString("Status", null)
    }
    fun putUser(userID : Long){
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putLong("userId", userID)
        editor.apply()
    }
    fun getUserValues() : Long {
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        return sharedPreferences!!.getLong("userId", -1)
    }
    fun putImageUser(image : String){
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString("imageUser", image)
        editor.apply()
    }
    fun getImageUser() : String? {
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString("imageUser", null)
    }
    fun putEmailUser(email : String){
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString("emailUser", email)
        editor.apply()
    }
    fun getEmailUser() : String? {
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString("emailUser", null)
    }
    fun putNameUser(name : String){
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString("nameUser", name)
        editor.apply()
    }
    fun getNameUser() : String? {
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString("nameUser", null)
    }
    fun deleteUser(){
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.remove("userId")
        editor.remove("imageUser")
        editor.remove("emailUser")
        editor.remove("nameUser")
        editor.remove("TokenUser")
        editor.apply()
    }
    fun putTokenUser(token : String){
        val sharedPreferences : SharedPreferences? = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString("TokenUser", token)
        editor.apply()
    }
    fun getTokenUser() : String? {
        val sharedPreferences: SharedPreferences? =
            context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString("TokenUser", null)
    }
}