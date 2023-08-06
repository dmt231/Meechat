package com.example.chatapp.adapter

import android.graphics.BitmapFactory

import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.LayoutRecyclerContactBinding

import com.example.chatapp.model.User

class AdapterContact(listUser : ArrayList<User>, listener : OnClickListener) : RecyclerView.Adapter<ViewHolderContact>() {
    private var listUser : ArrayList<User>
    private var listener : OnClickListener
    init {
        this.listUser = listUser
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContact {
       val binding = LayoutRecyclerContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderContact(binding)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolderContact, position: Int) {
        val model = listUser[position]
        holder.binding.userContact = model
        val bytes = Base64.decode(model.getImage(), Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
        holder.binding.imgContact.setImageBitmap(bitmap)
        holder.binding.layoutRecyclerContact.setOnClickListener {
            listener.onClick(model)
        }
    }
    interface OnClickListener{
        fun onClick(user : User)
    }
}
class ViewHolderContact(binding : LayoutRecyclerContactBinding):
    RecyclerView.ViewHolder(binding.root){
    var binding : LayoutRecyclerContactBinding
    init {
        this.binding = binding
    }
}