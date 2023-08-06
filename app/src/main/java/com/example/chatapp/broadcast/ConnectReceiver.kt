package com.example.chatapp.broadcast

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.chatapp.R

class ConnectReceiver(activity : Activity) : BroadcastReceiver() {
    private val activity : Activity
    init {
        this.activity = activity
    }
    var state : String? = null
    override fun onReceive(context: Context?, p1: Intent?) {
        if (p1!!.action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            val connectivityManager =
                context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
            if (isConnected) {
                try {
                    state = "Back to online"
                    customToastOnline(state!!,activity)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                state = "You're offline"
                customToastOffline(state!!, activity)
            }
        }
    }
     private fun customToastOnline(message : String, activity: Activity){
        val toast = Toast(activity)
        val inflater = activity.layoutInflater
        val viewInflate: View = inflater.inflate(
            R.layout.custom_toast_online,
            activity.findViewById(R.id.custom_toast_online)
        )
        val textMessage = viewInflate.findViewById<TextView>(R.id.text_toast_online)
        textMessage.text = message
        toast.view = viewInflate
        toast.setGravity(Gravity.BOTTOM, 0, 25)
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }
     private fun customToastOffline(message : String, activity: Activity){
        val toast = Toast(activity)
        val inflater = activity.layoutInflater
        val viewInflate: View = inflater.inflate(
            R.layout.custom_toast_offline,
            activity.findViewById(R.id.custom_toast_offline)
        )
        val textMessage = viewInflate.findViewById<TextView>(R.id.text_toast_offline)
        textMessage.text = message
        toast.view = viewInflate
        toast.setGravity(Gravity.BOTTOM, 0, 25)
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }
}