package com.example.chatapp.chat

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

import android.graphics.drawable.Drawable

import android.net.ConnectivityManager
import android.net.NetworkInfo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import retrofit2.Callback

import android.util.Base64
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.chatapp.R

import com.example.chatapp.adapter.AdapterChat
import com.example.chatapp.chat.info.InfoChat
import com.example.chatapp.chat.share.ShareScreen
import com.example.chatapp.cloudMessage.APIClient
import com.example.chatapp.cloudMessage.ApiService
import com.example.chatapp.cloudMessage.ConstantServices
import com.example.chatapp.databinding.CustomDialogForDetailChatBinding

import com.example.chatapp.databinding.LayoutChatBinding

import com.example.chatapp.model.User
import com.example.chatapp.repository.ChatRepository
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response


import java.io.ByteArrayOutputStream
import java.util.*

import kotlin.collections.ArrayList



@Suppress("NAME_SHADOWING")
class ChatScreen : Fragment() {
    private lateinit var binding : LayoutChatBinding
    private var user : User? = null
    private lateinit var preferences : Preferences
    private lateinit var adapter : AdapterChat
    private lateinit var chatRepository: ChatRepository
    private lateinit var userRepository: UserRepository
    private lateinit var listChat : ArrayList<ChatMessage>
    private lateinit var listImage : ArrayList<String>
    private var conversationId : String? = null
    private var isImage : Boolean = false
    private var tokenUser : String? = null
    private var onStatusReceivedID : Boolean = false
    private var lastTimeMessage : String? = null
    private var colorRecent = "#2E79F6"
    private var iconRecent : Bitmap? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutChatBinding.inflate(inflater, container, false)
        binding.fragmentChat.setOnClickListener {

        }
        binding.cancel.visibility = View.INVISIBLE
        listChat = ArrayList()
        listImage = ArrayList()
        preferences = Preferences(requireContext())
        chatRepository = ChatRepository()
        userRepository = UserRepository()
        binding.btnSend.setOnClickListener {
            if(binding.btnSend.isEnabled && binding.btnSend.visibility == View.VISIBLE) {
                if(checkNetwork()){
                    sendChat()
                }
                else{
                    customToastOffline("You're offline", requireActivity())
                }
            }
        }
        binding.btnSendIcon.setOnClickListener {
            if(binding.btnSendIcon.isEnabled && binding.btnSendIcon.visibility == View.VISIBLE){
                if(checkNetwork()){
                    sendIcon()
                }
                else{
                    customToastOffline("You're offline", requireActivity())
                }
            }
        }
        binding.picImage.setOnClickListener{
            if(binding.picImage.visibility == View.VISIBLE) {
                pickImage()
            }
        }
        binding.cancel.setOnClickListener {
            if(binding.cancel.visibility == View.VISIBLE)
            {
                cancelImage()
            }
        }
        binding.infoChat.setOnClickListener {
            onChangeToChatSetting(user!!.getImage(), colorRecent, iconRecent!!)
        }
        getDataUser()
        onTextChanged()
        onSetUpRecyclerView()
        setUpData()
        checkForConversation()
        getChat()
        back()
        onChangeStatusUser()
        getTokenReceivedUser()
        getStatusUser()
        return binding.root

    }


    override fun onResume() {
        super.onResume()
        binding.btnSendIcon.post {
            iconRecent = getIconBitmap(binding.btnSendIcon)
        }
    }

    private fun getIconBitmap(view : ImageView):Bitmap{
        val bitmap = Bitmap.createBitmap(
            view.width,
            view.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }


    private fun getTokenReceivedUser() {
        userRepository.getToken(user!!.getUserId(), object : UserRepository.OnSuccessListener{
            override fun onSuccess() {
                TODO("Not yet implemented")
            }

            override fun onAvailable() {
                TODO("Not yet implemented")
            }

            override fun onUnavailable() {
                TODO("Not yet implemented")
            }

            override fun onRemove(userId: Long) {
                TODO("Not yet implemented")
            }

            override fun onReceivedToken(token: String) {
                tokenUser = token
                user!!.setToken(tokenUser!!)
            }
        })
    }

    private fun getDataUser(){
        val bundle = arguments
        if(bundle != null){
            this.user = bundle["User"] as User
        }
    }
    private fun setUpData(){
        loadImageUser()
    }
    private fun loadImageUser(){
        binding.imageChat.setImageBitmap(getBitMapImage(user!!.getImage()))
    }
    private fun getBitMapImage(image : String) : Bitmap{
        val bytes = Base64.decode(image, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)

    }
    private fun back(){
        binding.btnBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }
    private fun getUserPresent() : Long{
        return preferences.getUserValues()
    }
    private fun onSetUpRecyclerView(){
        binding.recyclerViewChat.setHasFixedSize(false)
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterChat(getBitMapImage(user!!.getImage()), listChat, getUserPresent(), object : AdapterChat.OnClickListener{
            override fun changeToImage(image: String) {
                ShowImage().imageDialog(Gravity.CENTER,requireContext(), image, requireActivity(), preferences)
            }
        }, object : AdapterChat.OnLongClickListener{
            override fun onLongClick(position: Int) {
                showDialogForMessage(position)
            }

        })
        binding.recyclerViewChat.adapter = adapter
        binding.recyclerViewChat.visibility = View.INVISIBLE
    }
    private fun onTextChanged(){
        binding.chatInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0!!.isEmpty()){
                    binding.btnSend.visibility  = View.INVISIBLE
                    binding.btnSend.isEnabled = false
                    binding.btnSendIcon.visibility = View.VISIBLE
                    binding.btnSendIcon.isEnabled = true
                }else{
                    binding.btnSend.visibility  = View.VISIBLE
                    binding.btnSend.isEnabled = true
                    binding.btnSendIcon.visibility = View.INVISIBLE
                    binding.btnSendIcon.isEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }


    private fun sendIcon() {
        chatRepository.sendMessage(preferences.getUserValues(),
            user!!.getUserId(),
           encodeImage(iconRecent!!),
            Date(),
            2
        )
        if(!onStatusReceivedID){
            notificationForIcon()
        }
        if(conversationId != null){
            chatRepository.updateConversation(
                conversationId!!,
                "Send Icon",
                preferences.getUserValues(),
                0,
                2
            )
        }else{
            chatRepository.addConversation(preferences.getUserValues(),
                user!!.getUserId(),
                preferences.getNameUser()!!,
                user!!.getUsername(),
                preferences.getImageUser()!!,
                user!!.getImage(),
                "Send Icon",
                Date(),
                object : ChatRepository.GetConversation {
                    override fun getId(id: String) {
                        conversationId = id
                    }

                    override fun getColor(color: String) {
                        TODO("Not yet implemented")
                    }

                    override fun getLastTime(time: String) {
                        TODO("Not yet implemented")
                    }

                    override fun getIcon(icon: String) {
                        TODO("Not yet implemented")
                    }

                    override fun onFailure() {
                        TODO("Not yet implemented")
                    }
                },
               2
            )
        }
    }
    private fun sendChat(){
        if (isImage) {
            for (image in listImage) {
                chatRepository.sendMessage(
                    preferences.getUserValues(),
                    user!!.getUserId(),
                    image,
                    Date(),
                    1
                )
            }
            if (!onStatusReceivedID) {
                notificationForImage()
            }
            listImage.clear()
            binding.cancel.visibility = View.INVISIBLE
            binding.picImage.visibility = View.VISIBLE
        } else {
            chatRepository.sendMessage(
                preferences.getUserValues(),
                user!!.getUserId(),
                binding.chatInput.text.toString(),
                Date(),
                0
            )
            if (!onStatusReceivedID) {
                notificationForMessage()
            }
        }
        if (conversationId != null) {
            if (isImage) {
                chatRepository.updateConversation(
                    conversationId!!,
                    binding.chatInput.text.toString(),
                    preferences.getUserValues(),
                    0,
                    1
                )
            } else {
                chatRepository.updateConversation(
                    conversationId!!,
                    binding.chatInput.text.toString(),
                    preferences.getUserValues(),
                    0,
                    0
                )
            }

        } else {
            var isImageValue = 0
            if (isImage) {
                isImageValue = 1
            }
            chatRepository.addConversation(preferences.getUserValues(),
                user!!.getUserId(),
                preferences.getNameUser()!!,
                user!!.getUsername(),
                preferences.getImageUser()!!,
                user!!.getImage(),
                binding.chatInput.text.toString(),
                Date(),
                object : ChatRepository.GetConversation {
                    override fun getId(id: String) {
                        conversationId = id
                    }

                    override fun getColor(color: String) {
                        TODO("Not yet implemented")
                    }

                    override fun getLastTime(time: String) {
                        TODO("Not yet implemented")
                    }

                    override fun getIcon(icon: String) {
                        TODO("Not yet implemented")
                    }

                    override fun onFailure() {
                        TODO("Not yet implemented")
                    }
                },
                isImageValue.toLong()
            )

        }
        binding.chatInput.setText("")

    }


    private fun getChat(){
        chatRepository.getChat(preferences.getUserValues(), user?.getUserId()!!,listChat, object : ChatRepository.GetChatStatus{
            @SuppressLint("NotifyDataSetChanged")
            override fun RecentMessage() {
                adapter.notifyDataSetChanged()
                if(listChat.size != 0){
                    binding.infoChat.visibility = View.VISIBLE
                    checkForConversation()
                }
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun newMessage() {
                adapter.notifyDataSetChanged()
                binding.recyclerViewChat.smoothScrollToPosition(listChat.size-1)
                if(conversationId != null){
                    chatRepository.getLastId(conversationId!!, object : ChatRepository.OnReturnLastId{
                        override fun onReturnId(lastId: Long) {
                            Log.d("LastId", lastId.toString())
                            Log.d("Recent id ", preferences.getUserValues().toString())
                            if(preferences.getUserValues() != lastId){
                                chatRepository.updateSeenConversation(conversationId!!, 1)
                            }
                        }
                    })
                }
            }

            override fun noMessage() {
            }
        })
    }
    private fun getConversionName(){
        chatRepository.getNameConversation(preferences.getUserValues(), object : ChatRepository.GetConversionName{
            override fun getConversionName(conversation: ChatMessage) {
                if(conversation.conversionNickname.toString() == "null"){
                    binding.nameChat.text = conversation.conversionName
                }else{
                    binding.nameChat.text = conversation.conversionNickname
                }
                binding.nameChat.visibility = View.VISIBLE
                binding.imageChat.visibility = View.VISIBLE
                binding.status.visibility = View.VISIBLE
            }

        }, conversationId!!)
    }

    private fun checkForConversation(){
            chatRepository.checkForConversation(preferences.getUserValues(), user!!.getUserId(), object : ChatRepository.GetConversation{
                override fun getId(id: String) {
                    conversationId = id
                    getConversionName()
                    if(binding.recyclerViewChat.visibility == View.INVISIBLE) {
                        binding.recyclerViewChat.scrollToPosition(listChat.size - 1)
                        binding.recyclerViewChat.visibility = View.VISIBLE
                    }
                    if(binding.btnSendIcon.visibility == View.INVISIBLE){
                        binding.btnSendIcon.visibility = View.VISIBLE
                    }
                    chatRepository.getLastId(conversationId!!, object : ChatRepository.OnReturnLastId{
                        override fun onReturnId(lastId: Long) {
                            Log.d("LastId", lastId.toString())
                            Log.d("Recent id ", preferences.getUserValues().toString())
                            if(preferences.getUserValues() != lastId){
                                chatRepository.updateSeenConversation(conversationId!!, 1)
                            }
                        }
                    })
                }

                override fun getColor(color: String) {
                    adapter.changeColor(color)
                    colorRecent = color
                    binding.recyclerViewChat.scrollToPosition(listChat.size - 1)
                    binding.recyclerViewChat.visibility = View.VISIBLE
                }

                override fun getLastTime(time: String) {
                    lastTimeMessage = time
                }

                override fun getIcon(icon: String) {
                    iconRecent = getBitMapImage(icon)
                    binding.btnSendIcon.setImageBitmap(iconRecent)
                    binding.btnSendIcon.visibility = View.VISIBLE
                }

                override fun onFailure() {
                    binding.btnSendIcon.visibility = View.VISIBLE
                    binding.nameChat.text = user!!.getUsername()
                    binding.nameChat.visibility = View.VISIBLE
                    binding.status.visibility = View.VISIBLE
                    binding.imageChat.visibility = View.VISIBLE
                }
            })
    }
    private fun getStatusUser(){
        userRepository.getStatusUser(user!!.getUserId(), object : UserRepository.OnSuccessListener{
            override fun onSuccess() {
                TODO("Not yet implemented")
            }

            @SuppressLint("SetTextI18n")
            override fun onAvailable() {
                binding.status.text = "Online"
                binding.imageStatus.visibility = View.VISIBLE
                onStatusReceivedID = true

            }

            @SuppressLint("SetTextI18n")
            override fun onUnavailable() {
                binding.status.text = "Offline"
                binding.imageStatus.visibility = View.INVISIBLE
                onStatusReceivedID = false

            }

            override fun onRemove(userId: Long) {
                TODO("Not yet implemented")
            }

            override fun onReceivedToken(token: String) {
                TODO("Not yet implemented")
            }
        })
    }


    private fun onChangeStatusUser(){
        userRepository.getStatusChanged(user!!.getUserId(), object : UserRepository.OnSuccessListener{
            override fun onSuccess() {

            }

            @SuppressLint("SetTextI18n")
            override fun onAvailable() {
                binding.status.text = "Online"
                binding.imageStatus.visibility = View.VISIBLE
                onStatusReceivedID = true
            }

            @SuppressLint("SetTextI18n")
            override fun onUnavailable() {
                binding.status.text = "Offline"
                binding.imageStatus.visibility = View.INVISIBLE
                onStatusReceivedID = false
            }

            override fun onRemove(userId: Long) {
                TODO("Not yet implemented")
            }

            override fun onReceivedToken(token: String) {
                TODO("Not yet implemented")
            }
        })
    }
    private fun encodeImage(bitmap : Bitmap) : String{
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)
        val bytes = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }
    private fun pickImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_GET_CONTENT

        if (intent.resolveActivity(requireContext().packageManager) != null) {
            val chooserIntent = Intent.createChooser(intent, "Select Picture")
            chooserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivityForResult(intent, 1)
        } else {
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
        }

    }


    @Deprecated("Deprecated in Java")
    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (data?.data != null) {  //Trong trường hợp chọn 1 ảnh , thì kết quả trả về là data , tức là 1 Uri
                val imgUri = data.data
                try {
                    Glide.with(requireContext())     //Sử dụng Glide để convert từ Uri thành Bitmap , sau khi ảnh đã sẵn sàng và xử lý đúng
                        .asBitmap()
                        .load(imgUri)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(object : CustomTarget<Bitmap>() {
                            override fun onResourceReady(
                                resource: Bitmap,
                                transition: Transition<in Bitmap>?
                            ) {
                                // Xử lý ảnh đã xoay đúng ở đây
                                listImage.add(encodeImage(resource))
                                Log.d("Bitmap : ", "true")
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                                // Xử lý khi load ảnh bị xóa
                            }
                        })
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                binding.chatInput.setText("1 image picked ")
                binding.cancel.visibility = View.VISIBLE
                binding.picImage.visibility = View.INVISIBLE
                isImage = true
            } else if (data?.clipData != null) { //Trong trường hợp trả về nhiều ảnh, là clipData
                val count = data.clipData!!.itemCount //Lấy số lượng ảnh
                for (i in 0 until count) {
                    val imgUri = data.clipData!!.getItemAt(i).uri
                    try {
                        Glide.with(requireContext())
                            .asBitmap()
                            .load(imgUri)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
                            .into(object : CustomTarget<Bitmap>() {
                                override fun onResourceReady(
                                    resource: Bitmap,
                                    transition: Transition<in Bitmap>?
                                ) {
                                    // Xử lý ảnh đã xoay đúng ở đây
                                    listImage.add(encodeImage(resource))
                                    Log.d("Bitmap : ", resource.toString())
                                }

                                override fun onLoadCleared(placeholder: Drawable?) {
                                    // Xử lý khi load ảnh bị xóa
                                }
                            })
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    binding.chatInput.setText("$count images picked ")
                    binding.cancel.visibility = View.VISIBLE
                    binding.picImage.visibility = View.INVISIBLE
                    isImage = true
                }
            }
        }
    }

    private fun cancelImage(){
        binding.picImage.visibility = View.VISIBLE
        binding.cancel.visibility = View.INVISIBLE
        listImage.clear()
        isImage = false
        binding.chatInput.setText("")
    }

    private fun sendNotification(message: String) {
        APIClient().getClient().create(ApiService::class.java).sendMessage(
            ConstantServices().getRemoteMessageHeaders(), message)
            .enqueue(object : Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if(response.isSuccessful){
                        try{
                            if(response.body() != null){
                                val responseJson = JSONObject(response.body()!!)
                                val results = responseJson.getJSONArray("results")
                                if(responseJson.getInt("failure") == 1){
                                    val error = results[0] as JSONObject
                                    Log.d("Response Error:", error.toString())
                                    return
                                }
                            }
                        }catch ( e : JSONException){
                            e.printStackTrace()
                        }
                        Log.d("Send Notification : ", "Success")
                    }else{
                        Log.d("Error Send : ", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("Error : ", t.message.toString())
                }
            })

    }
    private fun notificationForImage(){
        try{
            //Lấy token của người nhận
            val tokens = JSONArray()
            tokens.put(user!!.getToken())

            val data = JSONObject()
            data.put("userId", preferences.getUserValues())
            data.put("Name", preferences.getNameUser())
            data.put("token_sending", preferences.getTokenUser())
            data.put("Message", preferences.getNameUser().toString() + " has send a image")


            val body = JSONObject()
            body.put(ConstantServices().remoteData, data)
            body.put(ConstantServices().registrationId, tokens)
            Log.d("Body :", body.toString())
            sendNotification(body.toString())

        }catch (exception : Exception){
            Log.d("Exception : ", exception.toString())
        }
    }
    private fun notificationForMessage(){
        try{
            //Lấy token của người nhận
            val tokens = JSONArray()
            tokens.put(user!!.getToken())

            val data = JSONObject()
            data.put("userId", preferences.getUserValues())
            data.put("Name", preferences.getNameUser())
            data.put("token_sending", preferences.getTokenUser())
            data.put("Message", binding.chatInput.text.toString())

            val body = JSONObject()
            body.put(ConstantServices().remoteData, data)
            body.put(ConstantServices().registrationId, tokens)

            Log.d("Body :", body.toString())
            sendNotification(body.toString())

        }catch (exception : Exception){
            Log.d("Exception : ", exception.toString())
        }
    }
    private fun notificationForIcon(){
        try{
            //Lấy token của người nhận
            val tokens = JSONArray()
            tokens.put(user!!.getToken())

            val data = JSONObject()
            data.put("userId", preferences.getUserValues())
            data.put("Name", preferences.getNameUser())
            data.put("token_sending", preferences.getTokenUser())
            data.put("Message", preferences.getNameUser().toString() + " has send a icon")

            val body = JSONObject()
            body.put(ConstantServices().remoteData, data)
            body.put(ConstantServices().registrationId, tokens)

            Log.d("Body :", body.toString())
            sendNotification(body.toString())

        }catch (exception : Exception){
            Log.d("Exception : ", exception.toString())
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun showDialogForMessage(position : Int){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding = CustomDialogForDetailChatBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(binding.root)
        val delete = dialog.findViewById<Button>(R.id.delete)
        val share = dialog.findViewById<Button>(R.id.share)
        //Xác định vị trí cho dialog
        val window = dialog.window

        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.BOTTOM
        windowAttributes.y = 60
        window.attributes = windowAttributes
        delete.setOnClickListener {
            chatRepository.deleteChat(listChat[position].chatId!!)
            listChat.removeAt(position)
            adapter.notifyDataSetChanged()
            val lastSize = listChat.size
            if(lastSize != 0) {
                val lastItem = listChat[lastSize-1]
                if (!lastTimeMessage!!.equals(lastItem.dateObject)) {
                    chatRepository.updateConversation(
                        conversationId!!,
                        lastItem.getMessage(),
                        lastItem.getSenderID(),
                        1,
                        lastItem.isImage!!
                    )
                }
            }else{
                chatRepository.deleteConservation(conversationId!!)
            }
            dialog.cancel()
        }
        share.setOnClickListener {
            val item = listChat[position]
            onChangeToShareScreen(item.isImage!!, item.getMessage())
            dialog.cancel()
        }
        dialog.show()
    }
    private fun onChangeToShareScreen(type : Long, message: String ){
        val shareScreen = ShareScreen()
        val fragmentManager = requireActivity().supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putLong("SenderId", preferences.getUserValues())
        bundle.putString("SenderName", preferences.getNameUser()!!)
        bundle.putLong("TypeOfMessage", type)
        bundle.putString("SenderImage", preferences.getImageUser()!!)
        bundle.putString("Message", message)
        shareScreen.arguments = bundle
        fragmentManager.replace(R.id.mainLayout, shareScreen)
        fragmentManager.addToBackStack(shareScreen.tag)
        fragmentManager.commit()
    }
    private fun onChangeToChatSetting(image : String, color : String, icon: Bitmap){
        val settingChat = InfoChat()
        val fragmentManager = requireActivity().supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putString("Image", image)
        bundle.putString("Color", color)
        bundle.putString("Icon", encodeImage(icon))
        bundle.putLong("ReceivedId", user!!.getUserId())
        bundle.putString("Conversation", conversationId)
        settingChat.arguments = bundle
        fragmentManager.replace(R.id.mainLayout, settingChat)
        fragmentManager.addToBackStack(null)
        fragmentManager.commit()
    }
    private fun checkNetwork() : Boolean{
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
        if (isConnected) {
            try {
                return true
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
                return false
        }
        return true
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
