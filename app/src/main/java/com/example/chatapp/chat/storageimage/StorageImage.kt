package com.example.chatapp.chat.storageimage

import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.adapter.AdapterStorage
import com.example.chatapp.chat.ChatMessage
import com.example.chatapp.chat.ShowImage
import com.example.chatapp.databinding.LayoutStorageBinding
import com.example.chatapp.repository.ChatRepository
import com.example.chatapp.storage.Preferences

class StorageImage : Fragment() {
    private lateinit var binding : LayoutStorageBinding
    private lateinit var chatRepository: ChatRepository
    private lateinit var adapter : AdapterStorage
    private lateinit var listImage : ArrayList<ChatMessage>
    private lateinit var preferences: Preferences
    private var receivedId : Long? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutStorageBinding.inflate(inflater, container,false)
        preferences = Preferences(requireContext())
        getData()
        chatRepository = ChatRepository()
        listImage = ArrayList()
        onSetUpRecyclerView()
        binding.btnBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getImage()
    }

    private fun getData(){
        val bundle = arguments
        if(bundle != null){
            receivedId = bundle["receivedId"] as Long
        }
    }
    private fun onSetUpRecyclerView(){
        binding.recyclerViewStorageImage.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerViewStorageImage.layoutManager = gridLayoutManager
        adapter = AdapterStorage(listImage, object : AdapterStorage.OnclickListener{
            override fun onClick(image: String) {
                ShowImage().imageDialog(Gravity.CENTER,requireContext(), image, requireActivity(), preferences)
            }
        })
        binding.recyclerViewStorageImage.adapter = adapter
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid_spacing)
        binding.recyclerViewStorageImage.addItemDecoration(GridItemDecoration(spacingInPixels, 3))

    }
    private fun getImage(){
        chatRepository.getImageStorage(preferences.getUserValues(), receivedId!!,listImage, object : ChatRepository.GetChatStatus{
            override fun RecentMessage() {
                adapter.notifyDataSetChanged()
            }

            override fun newMessage() {
                adapter.notifyDataSetChanged()
            }

            override fun noMessage() {
                TODO("Not yet implemented")
            }

        } )
    }
    class GridItemDecoration(private val spacing: Int, private val spanCount: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view)
            val column = position % spanCount

            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount

            if (position >= spanCount) {
                outRect.top = spacing
            }
        }
    }
}