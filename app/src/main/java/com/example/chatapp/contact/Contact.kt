package com.example.chatapp.contact

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
import com.example.chatapp.adapter.AdapterContact

import com.example.chatapp.databinding.LayoutContactBinding
import com.example.chatapp.login.LoginViewModel
import com.example.chatapp.main.MainFragment
import com.example.chatapp.model.User
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.storage.Preferences


class Contact(mainFragment : MainFragment) : Fragment(){
    private lateinit var binding : LayoutContactBinding
    private lateinit var adapter : AdapterContact
    private lateinit var listUser : ArrayList<User>
    private lateinit var viewModel : LoginViewModel
    private lateinit var repository: UserRepository
    private lateinit var preferences: Preferences
    private var mainFragment: MainFragment
    init {
        this.mainFragment = mainFragment
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutContactBinding.inflate(inflater, container, false)
        preferences = Preferences(requireContext())
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        repository = UserRepository()
        listUser = ArrayList()
        getData()
        return binding.root
    }
    fun onSetUpRecyclerView(){
        binding.recyclerViewContact.setHasFixedSize(true)
        binding.recyclerViewContact.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterContact(listUser, object : AdapterContact.OnClickListener{
            override fun onClick(user: User) {
                mainFragment.onChangedToChat(user)
            }

        })
        binding.recyclerViewContact.adapter = adapter
        val layoutManager = binding.recyclerViewContact.layoutManager as LinearLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerViewContact.context,
            layoutManager.orientation
        )
        binding.recyclerViewContact.addItemDecoration(dividerItemDecoration)
    }
    private fun getData() {
        repository.checkUserExist(object : UserRepository.OnExistListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onExist(exist: Boolean) {
                if (!exist) {
                    customToast("Not Found Any User")
                } else {
                    viewModel.getListUser().observe(viewLifecycleOwner) {
                        binding.progressBarContact.visibility = View.INVISIBLE
                        for (userValue in it) {
                            if (userValue.getUserId() != preferences.getUserValues()) {
                                listUser.add(userValue)
                            }
                        }
                        onSetUpRecyclerView()
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