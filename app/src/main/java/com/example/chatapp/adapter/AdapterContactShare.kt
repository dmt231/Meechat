package com.example.chatapp.adapter

import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.chat.ChatMessage
import com.example.chatapp.databinding.CustomRecyclerShareBinding
import com.example.chatapp.model.User
import java.util.*
import kotlin.collections.ArrayList

class AdapterContactShare(listUser : ArrayList<User>, listener : OnClickListener) : RecyclerView.Adapter<ViewHolderContactShare>(){
    private var listUser : ArrayList<User>
    private var listUserBackUp : ArrayList<User>? = null
    private var listener : OnClickListener
    init {
        this.listUser = listUser
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContactShare {
        val binding = CustomRecyclerShareBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderContactShare(binding)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolderContactShare, position: Int) {
        val model = listUser[position]
        holder.binding.userShare = model
        val bytes = Base64.decode(model.getImage(), Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
        holder.binding.imgContactShare.setImageBitmap(bitmap)
        holder.binding.buttonShare.setOnClickListener {
            listener.onClick(model)
            holder.binding.buttonShare.text = "Done"
        }
    }
    interface OnClickListener{
        fun onClick(user : User)
    }
    fun getFilter() : Filter {
        val f = object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val fr = FilterResults()
                if(listUserBackUp == null) {
                    listUserBackUp = ArrayList(listUser)
                }
                if(p0 == null || p0.isEmpty()){
                    fr.count = listUserBackUp!!.size
                    fr.values = listUserBackUp
                }
                else{
                    val newData = ArrayList<User>()
                    for(user in listUserBackUp!!){
                        if(user.getUsername().lowercase(Locale.ROOT).contains(p0.toString()
                                .lowercase(Locale.ROOT)))
                        {
                            newData.add(user)
                        }
                    }
                    fr.count = newData.size
                    fr.values = newData
                }
                return fr
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                listUser = ArrayList()
                val temp : ArrayList<User> = p1!!.values as ArrayList<User>
                for(chat in temp){
                    listUser!!.add(chat)
                    notifyDataSetChanged()
                }

            }

        }
        return f
    }

}
class ViewHolderContactShare(binding : CustomRecyclerShareBinding):
    RecyclerView.ViewHolder(binding.root){
    var binding : CustomRecyclerShareBinding
    init {
        this.binding = binding
    }
}