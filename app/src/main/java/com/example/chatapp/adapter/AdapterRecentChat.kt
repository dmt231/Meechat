package com.example.chatapp.adapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Base64


import android.widget.Filter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.chat.ChatMessage
import com.example.chatapp.databinding.LayoutRecentBinding
import java.util.*
import kotlin.collections.ArrayList



class AdapterRecentChat (listChat : ArrayList<ChatMessage>, onClickListener: OnClickListener) : RecyclerView.Adapter<RecentChatViewHolder>() {
    private var listChat : ArrayList<ChatMessage>? = null
    private var listChatBackUp : ArrayList<ChatMessage>? = null
    private val onClickListener : OnClickListener
    init {
        this.listChat = listChat
        this.onClickListener = onClickListener
    }

    private fun getRecentImage(encode : String) : Bitmap{
       val bytes = Base64.decode(encode, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentChatViewHolder {
        val layoutBinding = LayoutRecentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentChatViewHolder(layoutBinding)
    }

    override fun getItemCount(): Int {
        return listChat!!.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecentChatViewHolder, position: Int) {
        val chat = listChat!![position]
        if(chat.conversionNickname.equals("null")){
            holder.binding.nameContact.text = chat.conversionName
        }
        else{
            holder.binding.nameContact.text = chat.conversionNickname
        }

        holder.binding.imgContact.setImageBitmap(getRecentImage(chat.conversionImage!!))
        holder.binding.layoutRecyclerRecent.setOnClickListener {
            onClickListener.onClickListener(
                chat.getSenderID(),
                chat.getReceivedID(),
                chat.conversionImage!!,
                holder.binding.nameContact.text.toString()
            )
        }
        if (chat.lastId != chat.conversionId!!.toLong()){ //You
            if(chat.isImage!!.toInt() == 0){
                holder.binding.textRecent.text = "You: " + chat.getMessage()
            }else if(chat.isImage!!.toInt() == 2){
                holder.binding.textRecent.text = "You have send a icon."
            }else{
                holder.binding.textRecent.text = "You have send a image."
            }
        }
        else{ //Opponent
            if(chat.isImage!!.toInt() == 0){
                holder.binding.textRecent.text = chat.getMessage()
            }else if(chat.isImage!!.toInt() == 2){
                holder.binding.textRecent.text = chat.conversionName + " has send a icon "
            }
            else {
                holder.binding.textRecent.text = chat.conversionName + " has send a image "
            }
            if(chat.isSeen!!.toInt() == 0){
                holder.binding.textRecent.setTextColor(Color.BLACK)
                holder.binding.nameContact.setTextColor(Color.BLACK)
            }
        }
    }
    interface OnClickListener{
        fun onClickListener(senderId : Long, receivedId : Long, image : String, name : String )
    }
    fun getFilter() : Filter{
       val f = object : Filter(){
           override fun performFiltering(p0: CharSequence?): FilterResults {
               val fr = FilterResults()
               if(listChatBackUp == null) {
                   listChatBackUp = ArrayList(listChat!!)
               }
               if(p0 == null || p0.isEmpty()){
                       fr.count = listChatBackUp!!.size
                        fr.values = listChatBackUp
               }
               else{
                   val newData = ArrayList<ChatMessage>()
                   for(chat in listChatBackUp!!){
                        if(chat.conversionName!!.lowercase(Locale.ROOT).contains(p0.toString()
                                .lowercase(Locale.ROOT)))
                        {
                            newData.add(chat)
                        }
                   }
                   fr.count = newData.size
                   fr.values = newData
               }
               return fr
           }

           override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
               listChat = ArrayList()
               val temp : ArrayList<ChatMessage> = p1!!.values as ArrayList<ChatMessage>
               for(chat in temp){
                   listChat!!.add(chat)
                   notifyDataSetChanged()
               }

           }

       }
        return f
    }
}
class RecentChatViewHolder(binding : LayoutRecentBinding) : RecyclerView.ViewHolder(binding.root){
    var binding : LayoutRecentBinding
    init {
        this.binding = binding
    }
}
