package com.example.chatapp.cloudMessage

import android.Manifest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager

import android.os.Build

import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.example.chatapp.R
import com.example.chatapp.model.User
import com.example.chatapp.splash.Splash
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

import kotlin.random.Random

class MessageService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM : ", "Token$token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val user = User()
        user.setUserId(message.data["userId"]!!.toLong())
        user.setUsername(message.data["Name"]!!)
        user.setToken(message.data["token_sending"]!!)
        Log.d("Userid :", message.data["userId"]!!)
        Log.d("Name :", message.data["Name"]!!)
        Log.d("Token :", message.data["token_sending"]!!)


        //Notification id and channelId
        val notificationId = Random.nextInt()
        val channelId = "chat_message"

        //Intent when click on notification
        val intent = Intent(this,Splash::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        } else {
            TODO("VERSION.SDK_INT < M")
        }

        val notificationLayout = RemoteViews(packageName, R.layout.layout_push_notification)
        notificationLayout.setTextViewText(R.id.NameNotification, user.getUsername())
        notificationLayout.setTextViewText(R.id.NotificationMessage, message.data["Message"])

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.round_notifications_24)
        Log.d("Message : ", message.data["Message"]!!)
        builder.setStyle(NotificationCompat.DecoratedCustomViewStyle())
        builder.setCustomContentView(notificationLayout)
        builder.setContentIntent(pendingIntent)
        builder.setAutoCancel(false)

        //Create Channel
        if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.O) {
            val channelName = "Chat Message"
            val channelDescription = "Notification for chat message"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, channelName, importance)
            channel.description = channelDescription
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
        val notificationManagerCompat = NotificationManagerCompat.from(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        notificationManagerCompat.notify(notificationId, builder.build())
    }
}