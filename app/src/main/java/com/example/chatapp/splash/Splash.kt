package com.example.chatapp.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.chatapp.MainActivity
import com.example.chatapp.databinding.ActivitySplashBinding
import com.example.chatapp.storage.Preferences

class Splash : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    private lateinit var preferences: Preferences
    private val delayTIME = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        preferences = Preferences(this)
        setContentView(binding.root)
        Handler().postDelayed({
            val status = preferences.getStatusValues()
            val userId = preferences.getUserValues()
            if(status != null){
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("userId", userId)
                startActivity(i)
                finish()
            }else{
                val i = Intent(this, GetStarted::class.java)
                startActivity(i)
                finish()
            }
        }, delayTIME.toLong())
    }
}