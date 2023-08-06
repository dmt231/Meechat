package com.example.chatapp.chat.info.nickname

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.chatapp.databinding.DialogSetNicknameBinding
import com.example.chatapp.databinding.LayoutNicknameBinding
import com.example.chatapp.model.User
import com.example.chatapp.repository.ChatRepository
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences

class Nickname : Fragment(){
    private lateinit var binding : LayoutNicknameBinding
    private lateinit var chatRepository: ChatRepository
    private lateinit var userRepository: UserRepository
    private lateinit var preferences: Preferences
    private var userId2 : Long? = null
    private var userName2 : String? = null
    private lateinit var image2 : String
    private var conversationId : String? = null
    private var nicknameUser1 : String? = null
    private var nicknameUser2 : String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutNicknameBinding.inflate(inflater, container, false)
        preferences = Preferences(requireContext())
        chatRepository = ChatRepository()
        userRepository = UserRepository()
        binding.user1.setOnClickListener {
            showDialogForSetNickname(preferences.getUserValues())
        }
        binding.user2.setOnClickListener {
            showDialogForSetNickname(userId2!!)
        }
        binding.btnBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        getData()
        return binding.root
    }

    private fun showDialogForSetNickname(userId : Long) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val bindingDialog = DialogSetNicknameBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(bindingDialog.root)
        val window = dialog.window
        window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.CENTER
        window.attributes = windowAttributes
        if(userId == preferences.getUserValues()){
            if(nicknameUser1 != null){
                bindingDialog.editNickname.setText(nicknameUser1)
            }
        }else{
            if(nicknameUser2 != null){
                bindingDialog.editNickname.setText(nicknameUser2)
            }
        }
        bindingDialog.btnCancel.setOnClickListener {
            dialog.cancel()
        }
        bindingDialog.btnSave.setOnClickListener {
            chatRepository.updateNicknameConservation(conversationId!!, bindingDialog.editNickname.text.toString(), userId)
            if(userId == preferences.getUserValues()){
                binding.nickName1.text = preferences.getNameUser()
                binding.userName1.text = bindingDialog.editNickname.text.toString()
            }
            else{
                binding.nickName2.text = userName2
                binding.userName2.text = bindingDialog.editNickname.text.toString()

            }
            dialog.cancel()
        }
        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        getNameUser()
    }

    private fun getData(){
        val bundle = arguments
        if(bundle != null){
            this.image2 = bundle["Image2"] as String
            this.conversationId = bundle["ConversationId"] as String
            this.userId2 = bundle["receivedId"] as Long
            setData()
        }
    }

    private fun setData() {
        binding.imageUser1.setImageBitmap(getBitMapImage(preferences.getImageUser()!!))
        binding.imageUser2.setImageBitmap(getBitMapImage(image2))
    }

    private fun getBitMapImage(image : String) : Bitmap {
        val bytes = Base64.decode(image, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
    }
    private fun getNickname(){
        chatRepository.getNickname(conversationId!!, preferences.getUserValues(), object : ChatRepository.GetNickname{
            override fun getNickname(nickname: String) {
                binding.userName1.text = nickname
                binding.nickName1.text = preferences.getNameUser()
                binding.nickName1.visibility = View.VISIBLE
                nicknameUser1 = nickname
            }

            override fun noHaveNickname() {
                binding.userName1.text = preferences.getNameUser()
                binding.nickName1.visibility = View.VISIBLE
            }
        })

        chatRepository.getNickname(conversationId!!,userId2!! , object : ChatRepository.GetNickname{
            override fun getNickname(nickname: String) {
                binding.nickName2.text = userName2
                binding.userName2.text = nickname
                binding.nickName2.visibility = View.VISIBLE
                nicknameUser2 = nickname

            }

            override fun noHaveNickname() {
                binding.userName2.text = userName2
                binding.nickName2.visibility = View.VISIBLE
            }
        })
    }
    private fun getNameUser(){
        userRepository.getUserById(userId2!!,object : UserRepository.GetUser{
            override fun onSuccess(user: User) {
                userName2 = user.getUsername()
                getNickname()
            }
        })
    }
}