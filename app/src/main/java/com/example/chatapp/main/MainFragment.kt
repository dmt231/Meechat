package com.example.chatapp.main


import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import com.example.chatapp.R
import com.example.chatapp.broadcast.ConnectReceiver

import com.example.chatapp.chat.ChatScreen
import com.example.chatapp.contact.Contact
import com.example.chatapp.databinding.MainFragmentBinding
import com.example.chatapp.group.CreateGroupChat
import com.example.chatapp.group.GroupChatFragment
import com.example.chatapp.home.HomeFragment
import com.example.chatapp.login.Login
import com.example.chatapp.model.User
import com.example.chatapp.setting.Settings

class MainFragment() : Fragment() {
    private lateinit var binding : MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = MainFragmentBinding.inflate(inflater, container, false)
        onChangedToHome()
        onSetUpBottomBar()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

    private fun onChangedToSetting(){
        val fragmentTrans = activity?.supportFragmentManager!!.beginTransaction()
        fragmentTrans.replace(R.id.layoutMain, Settings(this))
        fragmentTrans.commit()
    }
    private fun onChangedToContact(){
        val fragmentTrans = activity?.supportFragmentManager!!.beginTransaction()
        val contact = Contact(this)
        fragmentTrans.replace(R.id.layoutMain, contact)
        fragmentTrans.commit()
    }
    private fun onChangedToHome(){
        val fragmentTrans = activity?.supportFragmentManager!!.beginTransaction()
        val homeFragment = HomeFragment(this)
        fragmentTrans.replace(R.id.layoutMain,homeFragment)
        fragmentTrans.commit()
    }
    private fun onSetUpBottomBar(){
        binding.bottomBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.setting -> {
                    onChangedToSetting()
                    binding.bottomBar.menu.findItem(R.id.setting).isChecked = true
                }
                R.id.messageIcon ->{
                    onChangedToHome()
                    binding.bottomBar.menu.findItem(R.id.messageIcon).isChecked = true
                }
                R.id.groupChat ->{
                    onChangedToGroupChat()
                    binding.bottomBar.menu.findItem(R.id.groupChat).isChecked = true
                }

                R.id.contact ->{
                    onChangedToContact()
                    binding.bottomBar.menu.findItem(R.id.contact).isChecked = true
                }
            }
            false
        }
    }
    fun signOut(){
        val login = Login()
        val fragmentTrans = activity?.supportFragmentManager!!.beginTransaction()
        fragmentTrans.replace(R.id.layoutMainFragment, login)
        fragmentTrans.addToBackStack(null)
        fragmentTrans.commit()
    }
    fun onChangedToChat(user: User) {
        val chatScreen = ChatScreen()
        val fragmentTrans = requireActivity().supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putSerializable("User", user)
        chatScreen.arguments = bundle
        fragmentTrans.replace(R.id.mainLayout, chatScreen)
        fragmentTrans.addToBackStack(null)
        fragmentTrans.commit()
    }
    fun onChangedToGroupChat(){
        val groupChat = GroupChatFragment(this)
        val fragmentTrans = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.layoutMain, groupChat)
        fragmentTrans.commit()
    }
    fun onChangedToCreateGroupChat(){
        val createGroupChat = CreateGroupChat()
        val fragmentTrans = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.mainLayout, createGroupChat)
        fragmentTrans.addToBackStack(createGroupChat.tag)
        fragmentTrans.commit()
    }
}