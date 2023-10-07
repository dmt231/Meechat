package com.example.chatapp.group

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.R
import com.example.chatapp.adapter.AdapterContactShare
import com.example.chatapp.adapter.AdapterCreateGroup
import com.example.chatapp.databinding.LayoutCreateGroupChatBinding
import com.example.chatapp.login.LoginViewModel
import com.example.chatapp.model.User
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences
import java.util.*
import kotlin.collections.ArrayList

class CreateGroupChat : Fragment() {
    private lateinit var binding : LayoutCreateGroupChatBinding
    private lateinit var adapter : AdapterCreateGroup
    private lateinit var listUser : ArrayList<User>
    private lateinit var viewModel : LoginViewModel
    private lateinit var repository: UserRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutCreateGroupChatBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        repository = UserRepository()
        listUser = ArrayList()
        setUpRecyclerView()
        loadUser()
        binding.cancel.setOnClickListener {
            back()
        }
        return binding.root
    }

    private fun back() {
        if(fragmentManager != null){
            fragmentManager?.popBackStack()
        }
    }

    private fun setUpRecyclerView(){
        binding.recyclerviewRecent.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterCreateGroup(listUser, object : AdapterCreateGroup.OnClickListener{
            override fun onSelect(user: User) {

            }

            override fun onUnSelected() {

            }


        })
        binding.recyclerviewRecent.adapter = adapter
        val layoutManager = binding.recyclerviewRecent.layoutManager as LinearLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerviewRecent.context,
            layoutManager.orientation
        )
        binding.recyclerviewRecent.addItemDecoration(dividerItemDecoration)
    }

    private fun loadUser() {
        repository.checkUserExist(object : UserRepository.OnExistListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onExist(exist: Boolean) {
                if (!exist) {
                    customToast("Not Found Any User")
                    binding.progressBarShare.visibility = View.INVISIBLE
                } else {
                    viewModel.getListUser().observe(viewLifecycleOwner) {
                        binding.progressBarShare.visibility = View.INVISIBLE
                        for (userValue in it) {
                            if (userValue.getUserId() != Preferences(requireContext()).getUserValues()) {
                                listUser.add(userValue)
                            }
                        }
                        adapter.notifyDataSetChanged()
                    }

                }
            }
        })
    }
    private fun customToast(message : String){
        val toast = Toast(activity)
        val inflater = layoutInflater
        val viewInflate: View = inflater.inflate(
            R.layout.layout_custom_toast,
            requireActivity().findViewById(R.id.custom_toast)
        )
        val textMessage = viewInflate.findViewById<TextView>(R.id.text_toast)
        textMessage.text = message
        toast.view = viewInflate
        toast.setGravity(Gravity.BOTTOM, 0, 25)
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }
}