package com.example.chatapp.login

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.util.Patterns
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.chatapp.R
import com.example.chatapp.databinding.SignupBinding
import com.example.chatapp.repository.UserRepository
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.InputStream

class SignUp : Fragment(){
    private lateinit var repository: UserRepository
    private lateinit var binding : SignupBinding
    private lateinit var btnBackToLogin : Button
    private lateinit var loginViewModel : LoginViewModel
    private var encodedImage : String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignupBinding.inflate(inflater, container, false)
        btnBackToLogin = binding.btnBackToLogin
        repository = UserRepository()
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        btnBackToLogin.setOnClickListener{
            backToLogin()
        }
        binding.chooseImage.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                val chooserIntent = Intent.createChooser(intent, "Select Picture")
                chooserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                startActivityForResult(intent, 1)
            }
        }
        binding.btnSignUp.setOnClickListener {
            if(validateInput()){
                binding.btnSignUp.visibility = View.INVISIBLE
                binding.progressBarSignUp.visibility = View.VISIBLE
                signUp()
            }
        }
        return binding.root
    }

    private fun backToLogin() {
        fragmentManager?.popBackStack()
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
                                binding.imageProfile.setImageBitmap(resource)
                                binding.txtImg.visibility = View.INVISIBLE
                                encodedImage = encodeImage(resource)
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
    private fun validateInput() : Boolean{
        var check = true
        if(binding.NameInput.text.isEmpty()){
            binding.NameInput.error = "Please Enter Your Name"
            check = false
        }
        else if(binding.passwordInput.text.toString().isEmpty()){
            binding.passwordInput.error = "Please Enter Your Password"
            check = false
        }
        else if(binding.passwordInput.text.toString().length < 8 || !binding.passwordInput.text.toString().matches(".*[A-Z].*".toRegex())){
            binding.passwordInput.error = "your password must be at least 8 characters long and contain an uppercase letter"
            check = false
        }
        else if(binding.emailInput.text.isEmpty()){
            binding.emailInput.error = "Please Enter Your Email"
            check = false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(binding.emailInput.text).matches()){
            binding.emailInput.error = "Your email is invalid"
            check = false
        }
        return check
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
    fun signUp(){
        val name  = binding.NameInput.text.toString()
        val password = binding.passwordInput.text.toString()
        val email = binding.emailInput.text.toString()
        repository.checkUserExist(object : UserRepository.OnExistListener{
            override fun onExist(exist: Boolean) {
                if(!exist){
                    repository.register(name, password, email, encodedImage!!, object : UserRepository.OnSuccessListener {
                        override fun onSuccess() {
                            customToast("Add Successfully !")
                            binding.btnSignUp.visibility = View.VISIBLE
                            binding.progressBarSignUp.visibility = View.INVISIBLE
                        }

                        override fun onAvailable() {
                            TODO("Not yet implemented")
                        }

                        override fun onUnavailable() {
                            TODO("Not yet implemented")
                        }

                        override fun onRemove(userId: Long) {
                            TODO("Not yet implemented")
                        }

                        override fun onReceivedToken(token: String) {
                            TODO("Not yet implemented")
                        }

                    } )
                }
                else{
                    loginViewModel.getListUser().observe(viewLifecycleOwner) {
                        var exist = false
                        for (user in it) {
                            if (user.getEmail() == email) {
                                exist = true
                                customToast("User's exits !")
                                binding.btnSignUp.visibility = View.VISIBLE
                                binding.progressBarSignUp.visibility = View.INVISIBLE
                                break
                            }
                        }
                        if (!exist) {
                            repository.register(
                                name,
                                password,
                                email,
                                encodedImage!!,
                                object : UserRepository.OnSuccessListener {
                                    override fun onSuccess() {
                                        customToast("Add Successfully !")
                                        binding.btnSignUp.visibility = View.VISIBLE
                                        binding.progressBarSignUp.visibility = View.INVISIBLE
                                    }

                                    override fun onAvailable() {
                                        TODO("Not yet implemented")
                                    }

                                    override fun onUnavailable() {
                                        TODO("Not yet implemented")
                                    }

                                    override fun onRemove(userId: Long) {
                                        TODO("Not yet implemented")
                                    }

                                    override fun onReceivedToken(token: String) {
                                        TODO("Not yet implemented")
                                    }

                                })
                        }
                    }
                }
            }

        })

    }


}