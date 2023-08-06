package com.example.chatapp.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatapp.chat.ChatMessage
import com.example.chatapp.databinding.LayoutRecyclerGridviewBinding

class AdapterStorage(listImage : ArrayList<ChatMessage>, onclickListener: OnclickListener) : RecyclerView.Adapter<ViewHolderStorage>() {
    private var listImage : ArrayList<ChatMessage>
    private var onclickListener : OnclickListener
    init {
        this.listImage = listImage
        this.onclickListener = onclickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderStorage {
        val binding = LayoutRecyclerGridviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderStorage(binding)
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onBindViewHolder(holder: ViewHolderStorage, position: Int) {
        val model = listImage[position]
        Glide.with(holder.binding.imageStorage)
            .load(getBitMapImage(model.getMessage()))
            .into(holder.binding.imageStorage)
        holder.binding.imageStorage.setOnClickListener {
            onclickListener.onClick(model.getMessage())
        }
    }
    private fun getBitMapImage(image : String) : Bitmap {
        val bytes = Base64.decode(image, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
    }
    interface OnclickListener{
        fun onClick(image : String)
    }
}
class ViewHolderStorage(binding : LayoutRecyclerGridviewBinding):
    RecyclerView.ViewHolder(binding.root){
    var binding : LayoutRecyclerGridviewBinding
    init {
        this.binding = binding
    }
}