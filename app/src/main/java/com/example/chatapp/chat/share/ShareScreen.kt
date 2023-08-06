package com.example.chatapp.chat.share

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
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
import com.example.chatapp.databinding.LayoutShareMessageBinding
import com.example.chatapp.login.LoginViewModel
import com.example.chatapp.model.User
import com.example.chatapp.repository.ChatRepository
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences
import java.util.*
import kotlin.collections.ArrayList

class ShareScreen : Fragment() {
    private lateinit var binding : LayoutShareMessageBinding
    private lateinit var adapter : AdapterContactShare
    private lateinit var listUser : ArrayList<User>
    private lateinit var viewModel : LoginViewModel
    private lateinit var repository: UserRepository
    private var senderId : Long? = null
    private var typeMessage : Long? = null
    private var message : String? = null
    private var senderName : String? = null
    private var senderImage : String? = null
    private lateinit var chatRepository: ChatRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutShareMessageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        repository = UserRepository()
        chatRepository = ChatRepository()
        listUser = ArrayList()
        getDataFromChatScreen()
        setUpRecyclerView()
        loadUser()
        binding.done.setOnClickListener {
            back()
        }
        searchUser()
        return binding.root
    }
    private fun getDataFromChatScreen(){
        val bundle = arguments
        if(bundle != null){
            senderId = bundle["SenderId"] as Long
            typeMessage = bundle["TypeOfMessage"] as Long
            message = bundle["Message"] as String
            senderName = bundle["SenderName"] as String
            senderImage = bundle["SenderImage"] as String
            Log.d("Type of message", typeMessage.toString())
            Log.d("sender User ", senderId.toString())
        }
    }
    private fun loadUser(){
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
    private fun searchUser(){
        binding.searchBarShare.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                adapter.getFilter().filter(p0.toString())
                adapter.notifyDataSetChanged()
            }

            override fun afterTextChanged(p0: Editable?) {

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
    private fun setUpRecyclerView(){
        binding.recyclerViewShareUser.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterContactShare(listUser, object : AdapterContactShare.OnClickListener{
            override fun onClick(user: User) {
                //Send Message
                if(typeMessage!!.toInt() == 0){
                    chatRepository.sendMessage(senderId!!, user.getUserId(),message!!, Date(), 0)

                }else{
                    chatRepository.sendMessage(senderId!!, user.getUserId(),message!!, Date(), 1)
                }
                checkForConservation(senderId!!, user.getUserId(), user.getUsername(), user.getImage())
                customToast("Send Successfully")
            }

        })
        binding.recyclerViewShareUser.adapter = adapter
        val layoutManager = binding.recyclerViewShareUser.layoutManager as LinearLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerViewShareUser.context,
            layoutManager.orientation
        )
        binding.recyclerViewShareUser.addItemDecoration(dividerItemDecoration)
    }
    private fun back(){
        if(fragmentManager != null){
            fragmentManager?.popBackStack()
        }
    }
    private fun checkForConservation(senderId : Long , receivedId : Long, receivedName : String, receivedImage : String){
        var conversationId: String?
        chatRepository.checkForConversation(senderId,receivedId, object : ChatRepository.GetConversation{
            override fun getId(id: String) {
                conversationId = id
                if(typeMessage!!.toInt() == 0){
                    chatRepository.updateConversation(conversationId!!, message!!,senderId,0,0)
                }else{
                    chatRepository.updateConversation(conversationId!!, "Send a image ",senderId,0,1)
                }
            }

            override fun getColor(color: String) {

            }

            override fun getLastTime(time: String) {

            }

            override fun getIcon(icon: String) {

            }

            override fun onFailure() {
                chatRepository.addConversation(senderId,receivedId,senderName!!, receivedName, senderImage!!,receivedImage,message!!
                    , Date(),object : ChatRepository.GetConversation{
                        override fun getId(id: String) {

                        }

                        override fun getColor(color: String) {

                        }

                        override fun getLastTime(time: String) {

                        }

                        override fun getIcon(icon: String) {

                        }

                        override fun onFailure() {

                        }
                    }, typeMessage!!)
            }
        })
    }
}