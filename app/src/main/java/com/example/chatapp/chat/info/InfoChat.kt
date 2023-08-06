package com.example.chatapp.chat.info

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Base64
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.chatapp.R
import com.example.chatapp.chat.ChatMessage
import com.example.chatapp.chat.info.nickname.Nickname
import com.example.chatapp.chat.storageimage.StorageImage
import com.example.chatapp.databinding.DialogSettingChatBinding
import com.example.chatapp.databinding.LayoutSelectColorBinding
import com.example.chatapp.databinding.LayoutSelectIconBinding
import com.example.chatapp.repository.ChatRepository
import com.example.chatapp.storage.Preferences
import io.grpc.Context.Storage
import java.io.ByteArrayOutputStream

@Suppress("NAME_SHADOWING")
class InfoChat : Fragment() {
    private lateinit var binding : DialogSettingChatBinding
    private lateinit var preferences: Preferences
    private lateinit var chatRepository : ChatRepository
    private var colorTheme : String? = null
    private var icon : Bitmap? = null
    private var image : String? = null
    private var conversationId : String? = null
    private var receivedId : Long? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogSettingChatBinding.inflate(inflater, container, false)
        preferences = Preferences(requireContext())
        chatRepository = ChatRepository()
        getData()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.Emoji.setOnClickListener {
            showDialogForChooseIcon()
        }
        binding.Theme.setOnClickListener {
            showDialogForChooseThemColor()
        }
        binding.btnBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        binding.MediaStore.setOnClickListener {
            onChangeToStorage()
        }
        binding.Nickname.setOnClickListener {
            onChangeToNickname()
        }
        getConversionName()
    }

    private fun getConversionName(){
        chatRepository.getNameConversation(preferences.getUserValues(), object : ChatRepository.GetConversionName{
            override fun getConversionName(conversation: ChatMessage) {
                if(conversation.conversionNickname.toString() == "null"){
                    binding.nameSettingChat.text = conversation.conversionName
                }else{
                    binding.nameSettingChat.text = conversation.conversionNickname
                }
            }
        }, conversationId!!)
    }



    private fun onChangeToNickname() {
        val nickName = Nickname()
        val fragmentManager = requireActivity().supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putString("ConversationId", conversationId)
        bundle.putLong("receivedId", receivedId!!)
        bundle.putString("Image2", image)
        nickName.arguments = bundle
        fragmentManager.replace(R.id.mainLayout, nickName)
        fragmentManager.addToBackStack(nickName.tag)
        fragmentManager.commit()
    }

    private fun getData(){
        val bundle = arguments
        if(bundle != null){
            this.colorTheme = bundle["Color"] as String
            this.icon = getBitMapImage(bundle["Icon"] as String)
            this.image = bundle["Image"] as String
            this.conversationId = bundle["Conversation"] as String
            this.receivedId = bundle["ReceivedId"] as Long
            setUpData()
        }
    }
    private fun setUpData(){
        binding.imageSettingChat.setImageBitmap(getBitMapImage(image!!))
        binding.recentEmojiPicked.setImageBitmap(icon)
        val drawable = (binding.recentThemePicked.background as GradientDrawable).mutate()
        (drawable as GradientDrawable).setColor(Color.parseColor(colorTheme))
    }
    private fun getBitMapImage(image : String) : Bitmap{
        val bytes = Base64.decode(image, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
    }
    private fun showDialogForChooseIcon(){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val bindingDialog = LayoutSelectIconBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(bindingDialog.root)
        bindingDialog.currentIcon.setImageBitmap(icon)
        val window = dialog.window
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var isSelect = false
        var stringImage : String? = null
        var bitmap : Bitmap? = null
        bindingDialog.iconLike.setOnClickListener {
            isSelect = true
            bindingDialog.currentIcon.setImageResource(R.drawable.like)
            bitmap = getIconBitmap(bindingDialog.iconLike)
            stringImage = encodeImage(bitmap!!)
        }
        bindingDialog.iconConfused.setOnClickListener {
            isSelect = true
            bindingDialog.currentIcon.setImageResource(R.drawable.confused)
            bitmap = getIconBitmap(bindingDialog.iconConfused)
            stringImage = encodeImage(bitmap!!)
        }
        bindingDialog.iconEmoji.setOnClickListener {
            isSelect = true
            bindingDialog.currentIcon.setImageResource(R.drawable.emoji)
            bitmap = getIconBitmap(bindingDialog.iconEmoji)
            stringImage = encodeImage(bitmap!!)
        }
        bindingDialog.iconSad.setOnClickListener {
            isSelect = true
            bindingDialog.currentIcon.setImageResource(R.drawable.sad)
            bitmap = getIconBitmap(bindingDialog.iconSad)
            stringImage = encodeImage(bitmap!!)
        }
        bindingDialog.iconSmile.setOnClickListener {
            isSelect = true
            bindingDialog.currentIcon.setImageResource(R.drawable.smile)
            bitmap = getIconBitmap(bindingDialog.iconSmile)
            stringImage = encodeImage(bitmap!!)
        }
        bindingDialog.iconSmileNotFun.setOnClickListener {
            isSelect = true
            bindingDialog.currentIcon.setImageResource(R.drawable.smile_not_fun)
            bitmap = getIconBitmap(bindingDialog.iconSmileNotFun)
            stringImage = encodeImage(bitmap!!)
        }
        bindingDialog.btnSelectIcon.setOnClickListener {
            if(isSelect){
                icon = bitmap
                changeIcon(stringImage!!)
                binding.recentEmojiPicked.setImageBitmap(icon)
                dialog.cancel()
            }
        }
        bindingDialog.btnCancelIcon.setOnClickListener {
            dialog.cancel()
        }
        dialog.show()
    }

    private fun showDialogForChooseThemColor(){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val bindingDialog = LayoutSelectColorBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(bindingDialog.root)
        val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
        (drawable as GradientDrawable).setColor(Color.parseColor(colorTheme))
        val window = dialog.window
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var isSelect = false
        var colorSelect : String? = null
        bindingDialog.colorBackground.setOnClickListener {
            isSelect = true
            colorSelect = "#2E79F6"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorGreen.setOnClickListener {
            isSelect = true
            colorSelect = "#128C7E"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorDarkGray.setOnClickListener {
            isSelect = true
            colorSelect = "#4b494c"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorOrange.setOnClickListener {
            isSelect = true
            colorSelect = "#F56040"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorPink.setOnClickListener {
            isSelect = true
            colorSelect = "#C13584"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorLightBlue.setOnClickListener {
            isSelect = true
            colorSelect = "#44c8ec"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorLightBrown.setOnClickListener {
            isSelect = true
            colorSelect = "#a18267"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorLightGray.setOnClickListener {
            isSelect = true
            colorSelect = "#b3c2ce"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorRed.setOnClickListener {
            isSelect = true
            colorSelect = "#FD1D1D"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        bindingDialog.colorYellow.setOnClickListener {
            isSelect = true
            colorSelect = "#FCAF45"
            val drawable = (bindingDialog.currentTheme.background as GradientDrawable).mutate()
            (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
        }
        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.CENTER
        window.attributes = windowAttributes

        bindingDialog.btnSelect.setOnClickListener {
            if(isSelect){
                changeColorThem(colorSelect!!)
                colorTheme = colorSelect
                val drawable = (binding.recentThemePicked.background as GradientDrawable).mutate()
                (drawable as GradientDrawable).setColor(Color.parseColor(colorSelect))
                dialog.cancel()
            }
        }
        bindingDialog.btnCancel.setOnClickListener {
            dialog.cancel()
        }
        dialog.show()
    }
    private fun getIconBitmap(view : ImageView):Bitmap{
        val bitmap = Bitmap.createBitmap(
            view.width,
            view.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }
    private fun encodeImage(bitmap : Bitmap) : String{
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)
        val bytes = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }
    private fun changeIcon(icon : String){
        chatRepository.updateIconConversation(conversationId!!, icon)
    }
    private fun changeColorThem(color : String) {
        chatRepository.updateThemColorConservation(conversationId!!, color)
    }
    private fun onChangeToStorage(){
        val storageImage = StorageImage()
        val fragmentManager = requireActivity().supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putLong("receivedId", receivedId!!)
        storageImage.arguments = bundle
        fragmentManager.replace(R.id.mainLayout, storageImage)
        fragmentManager.addToBackStack(storageImage.tag)
        fragmentManager.commit()
    }
}