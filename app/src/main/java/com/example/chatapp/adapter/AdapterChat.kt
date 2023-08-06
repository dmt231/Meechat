package com.example.chatapp.adapter


import android.annotation.SuppressLint

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Base64
import android.view.*

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.chatapp.chat.ChatMessage
import com.example.chatapp.databinding.LayoutReceivedIconBinding
import com.example.chatapp.databinding.LayoutReceivedImageBinding
import com.example.chatapp.databinding.LayoutReceivedMessageBinding
import com.example.chatapp.databinding.LayoutSendIconBinding
import com.example.chatapp.databinding.LayoutSendImageBinding
import com.example.chatapp.databinding.LayoutSendMessageBinding


class AdapterChat(imageProfile : Bitmap, listChat : ArrayList<ChatMessage>, senderID : Long, onClickListener: OnClickListener, onLongClick: OnLongClickListener) : RecyclerView.Adapter<ViewHolder>() {
    private var imageProfile : Bitmap
    private var listChat : ArrayList<ChatMessage>
    private var onClickListener : OnClickListener
    private var onLongClick : OnLongClickListener
    private var senderID : Long
    private val typeSend : Int = 1
    private val typeReceived : Int = 2
    private val typeSendImage : Int = 3
    private val typeReceivedImage : Int = 4
    private val typeSendIcon : Int = 5
    private val typeReceivedIcon : Int = 6
    private var color : String? = null
    private var isChangeColor = false
    init{
        this.imageProfile = imageProfile
        this.listChat = listChat
        this.senderID = senderID
        this.onClickListener = onClickListener
        this.onLongClick = onLongClick
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            typeSend -> {
                val binding = LayoutSendMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderSendMessage(binding, onLongClick)
            }
            typeReceived -> {
                val binding = LayoutReceivedMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderReceivedMessage(binding, onLongClick)
            }
            typeSendImage -> {
                val binding = LayoutSendImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderSendPictures(binding, onLongClick)
            }
            typeReceivedImage -> {
                val binding = LayoutReceivedImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderReceivedImage(binding, onLongClick)
            }
            typeSendIcon -> {
                val binding = LayoutSendIconBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderSendIcon(binding, onLongClick)
            }
            else -> {
                val binding = LayoutReceivedIconBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderReceivedIcon(binding, onLongClick)
            }
        }
    }

    override fun getItemCount(): Int {
        return listChat.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            typeSend -> {
                val sendHolder = holder as ViewHolderSendMessage
                sendHolder.setData(listChat[position])
                if (isChangeColor) {
                    sendHolder.changeMessageColor(color!!)
                }
            }
            typeReceived -> {
                val receivedHolder = holder as ViewHolderReceivedMessage
                receivedHolder.setData(listChat[position], imageProfile)
            }
            typeSendImage -> {
                val sendImageHolder = holder as ViewHolderSendPictures
                sendImageHolder.setData(listChat[position])
                sendImageHolder.binding.imageMessage.setOnClickListener {
                    onClickListener.changeToImage(listChat[position].getMessage())
                }
                sendImageHolder.binding.imageMessage.setOnLongClickListener {
                    sendImageHolder.onLongClick.onLongClick(position)
                    true
                }
            }
            typeReceivedImage -> {
                val receivedImageHolder = holder as ViewHolderReceivedImage
                receivedImageHolder.setData(listChat[position], imageProfile)
                receivedImageHolder.binding.imageReceived.setOnClickListener {
                    onClickListener.changeToImage(listChat[position].getMessage())
                }
                receivedImageHolder.binding.imageReceived.setOnLongClickListener {
                    receivedImageHolder.onLongClick.onLongClick(position)
                    true
                }
            }
            typeSendIcon ->{
                val sendIconHolder = holder as ViewHolderSendIcon
                sendIconHolder.setData(listChat[position])
                sendIconHolder.binding.iconMessage.setOnLongClickListener {
                    sendIconHolder.onLongClick.onLongClick(position)
                    true
                }
            }
            typeReceivedIcon ->{
                val receivedIconHolder = holder as ViewHolderReceivedIcon
                receivedIconHolder.setData(listChat[position], imageProfile)
                receivedIconHolder.binding.iconReceived.setOnLongClickListener {
                    receivedIconHolder.onLongClick.onLongClick(position)
                    true
                }
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        val chatMessage = listChat[position]
        if (chatMessage.isImage != null) {
            return if (chatMessage.getSenderID() == this.senderID) {
                if (chatMessage.isImage!!.toInt() == 0)
                    typeSend
                else if(chatMessage.isImage!!.toInt() == 1 )
                    typeSendImage
                else
                    typeSendIcon
            }
            else {
                if (chatMessage.isImage!!.toInt() == 0)
                    typeReceived
                else if (chatMessage.isImage!!.toInt() == 1)
                    typeReceivedImage
                else
                    typeReceivedIcon
            }
        }
        return super.getItemViewType(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun changeColor(color: String){
       isChangeColor = true
        this.color = color
        this.notifyDataSetChanged()
    }
    interface OnClickListener{
        fun changeToImage(image : String)
    }
    interface OnLongClickListener{
        fun onLongClick(position: Int)
    }

}
class ViewHolderSendMessage(binding : LayoutSendMessageBinding, onLongClick : AdapterChat.OnLongClickListener) : ViewHolder(binding.root) {
    var binding : LayoutSendMessageBinding
    init{
        this.binding = binding
        binding.root.setOnLongClickListener{
            onLongClick.onLongClick(adapterPosition)
            true
        }
    }
    fun setData(chatMessage: ChatMessage){
        binding.textMessage.text = chatMessage.getMessage()
        binding.timeMessage.text = chatMessage.getDatetime()
    }
    fun changeMessageColor(color : String){
        val drawable = (binding.textMessage.background as GradientDrawable).mutate()
        (drawable as GradientDrawable).setColor(Color.parseColor(color))
    }


}
class ViewHolderReceivedMessage(binding : LayoutReceivedMessageBinding, onLongClick: AdapterChat.OnLongClickListener) : ViewHolder(binding.root){
    var binding : LayoutReceivedMessageBinding
    init {
        this.binding = binding
        binding.root.setOnLongClickListener{
            onLongClick.onLongClick(adapterPosition)
            true
        }
    }
    fun setData(chatMessage: ChatMessage, img : Bitmap){
        binding.imgProfileReceived.setImageBitmap(img)
        binding.textReceived.text = chatMessage.getMessage()
        binding.timeMessageReceived.text = chatMessage.getDatetime()
    }
}
class ViewHolderSendPictures(binding : LayoutSendImageBinding, onLongClick: AdapterChat.OnLongClickListener) : ViewHolder(binding.root){
    var binding : LayoutSendImageBinding
    var onLongClick : AdapterChat.OnLongClickListener
    init{
        this.binding = binding
        this.onLongClick = onLongClick
    }
    @SuppressLint("CheckResult")
    fun setData(chatMessage: ChatMessage){
        binding.timeImage.text = chatMessage.getDatetime()
        Glide.with(binding.imageMessage)
            .load(getImage(chatMessage.getMessage()))
            .into(binding.imageMessage)
    }
    private fun getImage(encode : String) : Bitmap{
        val bytes = Base64.decode(encode, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}
class ViewHolderReceivedImage(binding : LayoutReceivedImageBinding, onLongClick: AdapterChat.OnLongClickListener) : ViewHolder(binding.root){
    var binding : LayoutReceivedImageBinding
    var onLongClick : AdapterChat.OnLongClickListener
    init {
        this.binding = binding
        this.onLongClick = onLongClick
    }
    fun setData(chatMessage: ChatMessage, img : Bitmap){
        binding.imgProfileReceivedImage.setImageBitmap(img)
        binding.timeImageReceived.text = chatMessage.getDatetime()
        Glide.with(binding.imageReceived)
            .load(getImage(chatMessage.getMessage()))
            .into(binding.imageReceived)
    }
    private fun getImage(encode : String) : Bitmap{
        val bytes = Base64.decode(encode, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}
class ViewHolderSendIcon(binding : LayoutSendIconBinding, onLongClick: AdapterChat.OnLongClickListener) : ViewHolder(binding.root){
    var binding : LayoutSendIconBinding
    var onLongClick : AdapterChat.OnLongClickListener
    init{
        this.binding = binding
        this.onLongClick = onLongClick
    }
    @SuppressLint("CheckResult")
    fun setData(chatMessage: ChatMessage){
        binding.timeIcon.text = chatMessage.getDatetime()
        Glide.with(binding.iconMessage)
            .load(getImage(chatMessage.getMessage()))
            .into(binding.iconMessage)
    }
    private fun getImage(encode : String) : Bitmap{
        val bytes = Base64.decode(encode, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}
class ViewHolderReceivedIcon(binding : LayoutReceivedIconBinding, onLongClick: AdapterChat.OnLongClickListener) : ViewHolder(binding.root){
    var binding : LayoutReceivedIconBinding
    var onLongClick : AdapterChat.OnLongClickListener
    init {
        this.binding = binding
        this.onLongClick = onLongClick
    }
    fun setData(chatMessage: ChatMessage, img : Bitmap){
        binding.imgProfileReceivedImage.setImageBitmap(img)
        binding.timeIconReceived.text = chatMessage.getDatetime()
        Glide.with(binding.iconReceived)
            .load(getImage(chatMessage.getMessage()))
            .into(binding.iconReceived)
    }
    private fun getImage(encode : String) : Bitmap{
        val bytes = Base64.decode(encode, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}
