package com.example.chatapp.adapter

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.chatapp.databinding.CustomRecylerCreateGroupChatBinding
import com.example.chatapp.model.User

class AdapterCreateGroup(listUser : ArrayList<User>, onclickListener : OnClickListener) : RecyclerView.Adapter<ViewHolderCreateGroup>() {

    private var listUser : ArrayList<User>
    private var onclickListener : OnClickListener
    init {
        this.listUser = listUser
        this.onclickListener = onclickListener
    }


    interface OnClickListener{
        fun onSelect(user : User)
        fun onUnSelected()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCreateGroup {
        val binding = CustomRecylerCreateGroupChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderCreateGroup(binding)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolderCreateGroup, position: Int) {
        var model = listUser[position]
        holder.binding.userNewGroup = model
        val bytes = Base64.decode(model.getImage(), Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
        Glide.with(holder.binding.imgContactShare).load(bitmap).into(holder.binding.imgContactShare)
        holder.binding.buttonShare.setOnClickListener {
            if(holder.binding.buttonShare.isSelected){
                onclickListener.onSelect(model)
            }else{
                onclickListener.onUnSelected()
            }
        }
    }
}
class ViewHolderCreateGroup(binding :CustomRecylerCreateGroupChatBinding):
    ViewHolder(binding.root){
    var binding : CustomRecylerCreateGroupChatBinding
    init {
        this.binding = binding
    }
}