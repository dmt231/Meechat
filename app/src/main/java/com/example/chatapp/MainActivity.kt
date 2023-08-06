package com.example.chatapp

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatapp.broadcast.ConnectReceiver


import com.example.chatapp.login.Login
import com.example.chatapp.main.MainFragment

import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences

class MainActivity : AppCompatActivity(), Login.OnChangedScreen {
    private lateinit var connectReceiver : ConnectReceiver
    private lateinit var intentFilter : IntentFilter
    private lateinit var userRepository: UserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userRepository = UserRepository()
        setContentView(R.layout.activity_main)
        onBroadcast()
        val fragmentTrans = supportFragmentManager.beginTransaction()
        val intent = intent
        val id = intent.getLongExtra("userId", -1).toInt()
        if(id == -1) {
            fragmentTrans.replace(R.id.mainLayout, Login())
        }else{
            fragmentTrans.replace(R.id.mainLayout, MainFragment())
        }
        fragmentTrans.commit()
    }
    private fun onBroadcast(){
        connectReceiver = ConnectReceiver(this)
        intentFilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(connectReceiver, intentFilter)
    }
    override fun onChanged(id: Long, image: String, email: String, name: String) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        val mainFragment = MainFragment()
        fragmentTrans.replace(R.id.mainLayout, mainFragment)
        fragmentTrans.addToBackStack(null)
        fragmentTrans.commit()
    }

    override fun onPause() {
        super.onPause()
        if(Preferences(this).getEmailUser() != null) {
            userRepository.updateStatusAvailable(0, Preferences(this).getEmailUser()!!)
        }
    }

    override fun onStop() {
        super.onStop()
        if(Preferences(this).getEmailUser() != null) {
            userRepository.updateStatusAvailable(0, Preferences(this).getEmailUser()!!)
        }
    }

    override fun onResume() {
        super.onResume()
        if(Preferences(this).getEmailUser() != null) {
            userRepository.updateStatusAvailable(1, Preferences(this).getEmailUser()!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectReceiver)
    }
}