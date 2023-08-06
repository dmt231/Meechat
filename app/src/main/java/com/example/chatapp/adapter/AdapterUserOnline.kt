package com.example.chatapp.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.LayoutOnlineUserBinding

import com.example.chatapp.model.User

class AdapterUserOnline(listUser : ArrayList<User>, listener : OnClickListener) : RecyclerView.Adapter<UserOnlineViewHolder>() {
    private var listUser : ArrayList<User>
    private var onClick : OnClickListener
    init {
        this.listUser = listUser
        this.onClick = listener
    }
    private fun getRecentImage(encode : String) : Bitmap {
        val bytes = Base64.decode(encode, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserOnlineViewHolder {
        val binding = LayoutOnlineUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserOnlineViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return listUser.size
    }

    override fun onBindViewHolder(holder: UserOnlineViewHolder, position: Int) {
       val user = listUser[position]
        holder.binding.imageOnline.setImageBitmap(getRecentImage(user.getImage()))
        var name = ""
        for(character in user.getUsername()){
            if(name.length < 9){
                name += character
            }else{
                name+="..."
                break
            }
        }
        holder.binding.nameUserOnline.text = name
        holder.binding.imageOnline.setOnClickListener {
            onClick.onClick(User(user.getUserId(), user.getUsername(), user.getImage()))
        }
    }
    interface OnClickListener{
        fun onClick(user : User)
    }
}
class UserOnlineViewHolder(binding : LayoutOnlineUserBinding) : RecyclerView.ViewHolder(binding.root){
    var binding : LayoutOnlineUserBinding
    init {
        this.binding = binding
    }
}