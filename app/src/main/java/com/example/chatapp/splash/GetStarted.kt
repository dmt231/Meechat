package com.example.chatapp.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import com.example.chatapp.MainActivity

import com.example.chatapp.databinding.ActivityGetStartedBinding
import com.example.chatapp.storage.Preferences

class GetStarted : AppCompatActivity() {
    private lateinit var binding : ActivityGetStartedBinding
    private lateinit var btnStart : Button
    private lateinit var preferences : Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = Preferences(this)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnStart = binding.btnStart
        btnStart.setOnClickListener {
            onStarted()
        }
    }

    fun onStarted() {
        preferences.putStatusValues("Started")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}