package com.example.chatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.LayoutRecyclerSettingBinding
import com.example.chatapp.model.Account

class AdapterSetting(listDetail : ArrayList<Account>, listener : OnChangeToDetail) : RecyclerView.Adapter<ViewHolderSetting>() {
    private var accountSetting : ArrayList<Account>
    private var listener : OnChangeToDetail
    init {
        this.accountSetting = listDetail
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSetting {
        val binding : LayoutRecyclerSettingBinding = LayoutRecyclerSettingBinding.inflate(
            LayoutInflater.from(parent.context), parent,false)
        return ViewHolderSetting(binding)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ViewHolderSetting, position: Int) {
        val model = accountSetting[position]
        holder.binding.imgIconRecycler.setImageResource(model.getImage())
        holder.binding.elementSetting.text = model.getDetail()
        if(model.getDetail() == "Sign Out") {
            holder.binding.imgIconRecycler.setOnClickListener {
                listener.onClickListener()
            }
        }

    }
    interface OnChangeToDetail{
        fun onClickListener()
    }
}
class ViewHolderSetting(binding : LayoutRecyclerSettingBinding):
        RecyclerView.ViewHolder(binding.root){
        var binding : LayoutRecyclerSettingBinding
            init {
                this.binding = binding
            }
        }
