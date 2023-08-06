package com.example.chatapp.setting

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.chatapp.R
import com.example.chatapp.adapter.AdapterSetting
import com.example.chatapp.databinding.DialogImageProfileBinding
import com.example.chatapp.databinding.LayoutImageProfileBinding
import com.example.chatapp.databinding.LayoutSettingBinding

import com.example.chatapp.main.MainFragment
import com.example.chatapp.model.Account
import com.example.chatapp.model.User
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.InputStream


class Settings(mainFragment : MainFragment) : Fragment(){
    private lateinit var binding : LayoutSettingBinding
    private lateinit var adapter : AdapterSetting
    private lateinit var listDetail : ArrayList<Account>
    private var mainFragment : MainFragment
    private lateinit var repository : UserRepository
    private lateinit var preferences: Preferences
    init{
        this.mainFragment = mainFragment
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutSettingBinding.inflate(inflater, container, false)
        repository = UserRepository()
        preferences = Preferences(requireContext())
        logTest()
        loadImageUser()
        listDetail = ArrayList()
        listDetail.add(Account(R.drawable.email, preferences.getEmailUser()!!))
        listDetail.add(Account(R.drawable.use_img, preferences.getNameUser()!!))
        listDetail.add(Account(R.drawable.documents, "Policy"))
        listDetail.add(Account(R.drawable.log_out, "Sign Out"))
        setUpRecycler()
        binding.nameSetting.text = preferences.getNameUser()!!
        binding.layoutChooseImage.setOnClickListener {
            openDialogImageProfile()
        }
        return binding.root
    }
    private fun logTest(){
        Log.d("Name User" , preferences.getNameUser()!!)
        Log.d("Email User" , preferences.getEmailUser()!!)
    }
    private fun loadImageUser(){
        binding.imageSetting.setImageBitmap(getImageProfileBitmap())
    }
    private fun getImageProfileBitmap(): Bitmap {
        val bytes = Base64.decode(preferences.getImageUser(), Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
    private fun setUpRecycler(){
        binding.recyclerViewSetting.setHasFixedSize(true)
        binding.recyclerViewSetting.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterSetting(listDetail, object : AdapterSetting.OnChangeToDetail{
            override fun onClickListener() {
                mainFragment.signOut()
                repository.signOut(preferences.getEmailUser()!!)
                repository.updateStatusAvailable(0, preferences.getEmailUser()!!)
                Preferences(requireContext()).deleteUser()
            }

        })
        binding.recyclerViewSetting.adapter = adapter
        val layoutManager = binding.recyclerViewSetting.layoutManager as LinearLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerViewSetting.context,
            layoutManager.orientation
        )
        binding.recyclerViewSetting.addItemDecoration(dividerItemDecoration)
    }
    private fun openDialogImageProfile(){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding = DialogImageProfileBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(binding.root)
        val window = dialog.window
        window!!.setLayout( WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.BOTTOM
        binding.SeeImage.setOnClickListener {
            onChangeToSeeImage(getImageProfileBitmap(), false)
            dialog.cancel()
        }
        binding.SelectImage.setOnClickListener {
            openMedia()
            dialog.cancel()
        }
        dialog.show()
    }

    private fun onChangeToSeeImage(imageBitmap : Bitmap, isSelect : Boolean) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val bindingDialog = LayoutImageProfileBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(bindingDialog.root)
        val window = dialog.window
        window!!.setLayout( WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.CENTER
        bindingDialog.detailImage.setImageBitmap(imageBitmap)
        bindingDialog.cancelViewImage.setOnClickListener {
            dialog.cancel()
        }
        if(isSelect){
            bindingDialog.done.visibility = View.VISIBLE
        }
        bindingDialog.done.setOnClickListener {
            val imageString = encodeImage(imageBitmap)
            repository.updateImage(imageString, preferences.getEmailUser()!!)
            Preferences(requireContext()).putImageUser(imageString)
            binding.imageSetting.setImageBitmap(imageBitmap)
            dialog.cancel()
        }
        dialog.show()
    }
    private fun openMedia(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        if (intent.resolveActivity(requireContext().packageManager) != null) {
            val chooserIntent = Intent.createChooser(intent, "Select Picture")
            chooserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivityForResult(intent, 1)
        }
    }
    private fun encodeImage(bitmap : Bitmap) : String{
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)
        val bytes = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (data?.data != null) {  //Trong trường hợp chọn 1 ảnh , thì kết quả trả về là data , tức là 1 Uri
                val imgUri = data.data
                try {
                    Glide.with(requireContext())     //Sử dụng Glide để convert từ Uri thành Bitmap , sau khi ảnh đã sẵn sàng và xử lý đúng
                        .asBitmap()
                        .load(imgUri)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(object : CustomTarget<Bitmap>() {
                            override fun onResourceReady(
                                resource: Bitmap,
                                transition: Transition<in Bitmap>?
                            ) {
                                // Xử lý ảnh đã xoay đúng ở đây
                                onChangeToSeeImage(resource, true)
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                                // Xử lý khi load ảnh bị xóa
                            }
                        })
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

}