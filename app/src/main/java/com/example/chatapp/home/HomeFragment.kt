package com.example.chatapp.home

import android.annotation.SuppressLint
import android.app.Dialog

import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Base64
import android.util.Log

import android.view.*
import android.widget.Button

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.adapter.AdapterRecentChat
import com.example.chatapp.adapter.AdapterUserOnline
import com.example.chatapp.chat.ChatMessage

import com.example.chatapp.databinding.HomeFragmentBinding

import com.example.chatapp.main.MainFragment
import com.example.chatapp.model.User
import com.example.chatapp.repository.ChatRepository
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences
import com.google.firebase.messaging.FirebaseMessaging


class HomeFragment( mainFragment: MainFragment) : Fragment() {
    private  var mainFragment: MainFragment
    private lateinit var repository: UserRepository
    private lateinit var chatRepository: ChatRepository
    private lateinit var binding : HomeFragmentBinding
    private lateinit var conservation : ArrayList<ChatMessage>
    private lateinit var conservationAdapter : AdapterRecentChat
    private lateinit var listUser : ArrayList<User>
    private lateinit var preferences: Preferences
    private lateinit var userOnlineAdapter : AdapterUserOnline
    private var token : String? = null
    init{
        this.mainFragment = mainFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        repository = UserRepository()
        chatRepository = ChatRepository()
        preferences = Preferences(requireContext())
        loadImageUser()
        getToken()
        conservation = ArrayList()
        listUser = ArrayList()
        setUpRecyclerView()
        setUpRecyclerViewOnline()
        getUserOnline()
        getConservation()
        onSearchUser()
        swipeToDelete()
        return binding.root
    }

    private fun loadImageUser(){
        val bytes = Base64.decode(preferences.getImageUser(), Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
        binding.imgProfile.setImageBitmap(bitmap)
    }
    private fun getToken(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if(it.isSuccessful){
                token = it.result
                putToken()
            }
        }
    }
    private fun putToken(){
        repository.updateToken(token!!, preferences.getEmailUser()!!)
        preferences.putTokenUser(token!!)
    }
    private fun setUpRecyclerView(){
        binding.recyclerviewRecent.setHasFixedSize(true)
        binding.recyclerviewRecent.layoutManager = LinearLayoutManager(activity)
        conservationAdapter = AdapterRecentChat(conservation, object : AdapterRecentChat.OnClickListener{

            override fun onClickListener(
                senderId: Long,
                receivedId: Long,
                image: String,
                name: String
            ) {
                if(preferences.getUserValues()== senderId){
                    val user = User(receivedId, name, image)
                    mainFragment.onChangedToChat(user)
                }else if(preferences.getUserValues() == receivedId){
                    val user = User(senderId,name, image)
                    mainFragment.onChangedToChat(user)
                }
            }
        })
        binding.recyclerviewRecent.adapter = conservationAdapter
    }
    private fun setUpRecyclerViewOnline(){
        binding.recyclerViewUserOnline.setHasFixedSize(true)
        val layout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewUserOnline.layoutManager = layout
        userOnlineAdapter = AdapterUserOnline(listUser, object :  AdapterUserOnline.OnClickListener {
            override fun onClick(user: User) {
                mainFragment.onChangedToChat(user)
            }
        })
        binding.recyclerViewUserOnline.adapter = userOnlineAdapter
    }
    private fun getConservation(){
        chatRepository.getConversation(preferences.getUserValues(), conservation, object : ChatRepository.GetChatStatus{
            override fun RecentMessage() {

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun newMessage() {
                conservation.sortWith { obj1, obj2 ->
                    obj2.dateObject!!.compareTo(obj1.dateObject)
                }
                for(conversations in conservation){
                    repository.getImageUserById(conversations.conversionId!!.toLong(),
                        object : UserRepository.GetUser {
                            override fun onSuccess(user: User) {
                                TODO("Not yet implemented")
                            }

                            override fun getImage(image: String) {
                                conversations.conversionImage = image
                                conservationAdapter.notifyDataSetChanged()
                            }

                        } )

                }
//                conservationAdapter.notifyDataSetChanged()
            }

            override fun noMessage() {
                TODO("Not yet implemented")
            }

        })
    }
    private fun getUserOnline(){
        repository.getUserAvailable(preferences.getUserValues(),listUser, object : UserRepository.OnSuccessListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onSuccess() {
                userOnlineAdapter.notifyDataSetChanged()
            }

            override fun onAvailable() {
                TODO("Not yet implemented")
            }

            override fun onUnavailable() {

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onRemove(userId: Long) {
                for(user in listUser){
                  if(user.getUserId() == userId)
                  {
                      listUser.remove(user)
                      break
                  }
                }
                userOnlineAdapter.notifyDataSetChanged()
            }

            override fun onReceivedToken(token: String) {
                TODO("Not yet implemented")
            }
        })
    }
    private fun onSearchUser(){
        binding.searchBar.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                conservationAdapter.getFilter().filter(p0.toString())
                conservationAdapter.notifyDataSetChanged()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
    private fun swipeToDelete(){
        lateinit var itemTouchHelper: ItemTouchHelper
        val swipeToDeleteCallBack = object : SwipeToDeleteCallBack(requireContext()){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                showDialogForConservation(position)
                conservationAdapter.notifyItemChanged(position)
            }

        }
        itemTouchHelper = ItemTouchHelper(swipeToDeleteCallBack)
        itemTouchHelper.attachToRecyclerView(binding.recyclerviewRecent)
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun showDialogForConservation(position : Int){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_confirm)
        val delete = dialog.findViewById<Button>(R.id.btn_yes_delete)
        val cancel = dialog.findViewById<Button>(R.id.btn_no_delete)
        val window = dialog.window
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.CENTER
        window.attributes = windowAttributes
        cancel.setOnClickListener {
            dialog.cancel()
        }
        delete.setOnClickListener {
            val conservationItem = conservation[position]
            chatRepository.deleteConservation(conservationItem.documentId!!)
            chatRepository.deleteAllChat(conservationItem.getSenderID(), conservationItem.getReceivedID())
            conservation.removeAt(position)
            conservationAdapter.notifyDataSetChanged()
            dialog.cancel()
        }
        dialog.show()
    }
}