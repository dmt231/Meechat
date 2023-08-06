package com.example.chatapp.login

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.LoginBinding
import com.example.chatapp.model.User
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences


open class Login : Fragment() {
    private lateinit var binding : LoginBinding
    private lateinit var btnCreate : Button
    private lateinit var changedScreen : OnChangedScreen
    private lateinit var loginViewModel : LoginViewModel
    private lateinit var repository: UserRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginBinding.inflate(inflater, container, false)
        btnCreate = binding.btnCreateAccount
        btnCreate.setOnClickListener{
            onChangedToCreate()
        }
        repository = UserRepository()
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.btnSignIn.setOnClickListener {
            if(validate()){
                binding.btnSignIn.visibility = View.INVISIBLE
                binding.progressBarSignIn.visibility = View.VISIBLE
                val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
                val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
                if(isConnected){
                    signIn()
                }
                else{
                    customToast("You're offline")
                }
            }
        }
        return binding.root
    }


    private fun signIn(){
        val email = binding.emailInput.text.toString()
        val password = binding.passwordInput.text.toString()
        repository.checkUserExist(object : UserRepository.OnExistListener {
            override fun onExist(exist: Boolean) {
                if (!exist) {
                    customToast("Username or Password is incorrect")
                }
                else{
                    loginViewModel.getListUser().observe(viewLifecycleOwner) {
                        var check = false
                        var id: Long = 0
                        var img: String? = null
                        var name: String? = null
                        for (user in it) {
                            if (checkLogin(user, email, password)) {
                                check = true
                                id = user.getUserId()
                                img = user.getImage()
                                name = user.getUsername()
                                break
                            }
                        }
                        if (check) {
                            val preferences = Preferences(requireContext())
                            preferences.putUser(id)
                            preferences.putImageUser(img!!)
                            preferences.putEmailUser(email)
                            preferences.putNameUser(name!!)
                            changedScreen.onChanged(id, img, email, name)
                        } else {
                            customToast("Username or Password is incorrect")
                            binding.btnSignIn.visibility = View.VISIBLE
                            binding.progressBarSignIn.visibility = View.INVISIBLE
                        }
                    }
                }
            }
        })
    }


    private fun onChangedToCreate() {
        val signUp = SignUp()
        val fragmentTrans = childFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.loginPage, signUp)
        fragmentTrans.addToBackStack(signUp.tag)
        fragmentTrans.commit()
    }
    fun checkLogin(user: User, email: String, password: String): Boolean {
        var check = false
        if (user.getEmail()== email && user.getPassword() == password) {
            check = true
        }
        return check
    }
    private fun validate() : Boolean{
        var check  = true
        if(binding.emailInput.text.toString().isEmpty()){
            binding.emailInput.error = "Please Enter Your Email"
            check = false
        }
        else if(binding.passwordInput.text.toString().isEmpty()){
            binding.passwordInput.error = "Please Enter Your Password"
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
    interface OnChangedScreen {
        fun onChanged(id: Long, image : String, email : String, name : String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            changedScreen = context as OnChangedScreen
        }catch (e : ClassCastException){
            throw ClassCastException(context.toString())
        }
    }
}