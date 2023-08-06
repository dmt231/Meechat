package com.example.chatapp.chat

import android.app.Activity
import android.app.Dialog
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64

import android.view.Gravity

import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.chatapp.R
import com.example.chatapp.chat.share.ShareScreen
import com.example.chatapp.databinding.LayoutDetailImageBinding
import com.example.chatapp.storage.Preferences
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class ShowImage {
    fun imageDialog(gravity : Int, context: Context , imageCode : String, activity: FragmentActivity, preferences: Preferences){
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding = LayoutDetailImageBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(binding.root)
        //Xác định vị trí cho dialog
        val window = dialog.window

        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val windowAttributes = window.attributes
        windowAttributes.gravity = gravity
        window.attributes = windowAttributes
        binding.detailImage.setImageBitmap(decodedImage(imageCode))
        binding.cancelImage.setOnClickListener {
            dialog.cancel()
        }
        binding.downloadImage.setOnClickListener {
            downloadImage(decodedImage(imageCode), "Image${decodedImage(imageCode)}.jpg", context, activity)
        }
        binding.optionShare.setOnClickListener {
            onChangeToShareScreen(1, imageCode,activity, preferences)
            dialog.cancel()
        }
        dialog.show()
    }
    private fun decodedImage(encoded : String) : Bitmap{
        val bytes = Base64.decode(encoded, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
    }
    private fun downloadImage(bitmap: Bitmap, filename : String, context: Context, activity: Activity){
        val outputStream : OutputStream
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) //Lớn hơn phiên bản android 10
        {
            val resolver = context.applicationContext.contentResolver  //Sử dụng contentResolver
            val contentValues = ContentValues().apply { //Thêm bộ giá trị
                put(MediaStore.MediaColumns.DISPLAY_NAME, filename) //Thêm vào media với tên là filename
                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")//Định dạng tệp
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
            }
            val imageUri = resolver!!.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            outputStream = resolver.openOutputStream(imageUri!!)!!


        }
        else{
            val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val imageFile = File(imagesDir, filename)
            outputStream = FileOutputStream(imageFile)
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.close()
        customToast("Downloaded Successfully !", activity)


    }
    private fun customToast(message : String, activity: Activity){
        val toast = Toast(activity.applicationContext)
        val inflater = activity.layoutInflater
        val viewInflate: View = inflater.inflate(
            R.layout.layout_custom_toast,
            activity.findViewById(R.id.custom_toast)
        )
        val textMessage = viewInflate.findViewById<TextView>(R.id.text_toast)
        textMessage.text = message
        toast.view = viewInflate
        toast.setGravity(Gravity.BOTTOM, 0, 25)
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }
    private fun onChangeToShareScreen(type : Long, message: String, activity: FragmentActivity , preferences : Preferences ){
        val shareScreen = ShareScreen()
        val fragmentManager = activity.supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putLong("SenderId", preferences.getUserValues()!!)
        bundle.putString("SenderName", preferences.getNameUser()!!)
        bundle.putLong("TypeOfMessage", type)
        bundle.putString("SenderImage", preferences.getImageUser()!!)
        bundle.putString("Message", message)
        shareScreen.arguments = bundle
        fragmentManager.replace(R.id.mainLayout, shareScreen)
        fragmentManager.addToBackStack(null)
        fragmentManager.commit()
    }
}