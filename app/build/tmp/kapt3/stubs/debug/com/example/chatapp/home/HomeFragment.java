package com.example.chatapp.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010\'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0003J\b\u0010-\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/example/chatapp/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "mainFragment", "Lcom/example/chatapp/main/MainFragment;", "(Lcom/example/chatapp/main/MainFragment;)V", "binding", "Lcom/example/chatapp/databinding/HomeFragmentBinding;", "chatRepository", "Lcom/example/chatapp/repository/ChatRepository;", "conservation", "Ljava/util/ArrayList;", "Lcom/example/chatapp/chat/ChatMessage;", "Lkotlin/collections/ArrayList;", "conservationAdapter", "Lcom/example/chatapp/adapter/AdapterRecentChat;", "listUser", "Lcom/example/chatapp/model/User;", "preferences", "Lcom/example/chatapp/storage/Preferences;", "repository", "Lcom/example/chatapp/repository/UserRepository;", "token", "", "userOnlineAdapter", "Lcom/example/chatapp/adapter/AdapterUserOnline;", "getConservation", "", "getToken", "getUserOnline", "loadImageUser", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSearchUser", "putToken", "setUpRecyclerView", "setUpRecyclerViewOnline", "showDialogForConservation", "position", "", "swipeToDelete", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private com.example.chatapp.main.MainFragment mainFragment;
    private com.example.chatapp.repository.UserRepository repository;
    private com.example.chatapp.repository.ChatRepository chatRepository;
    private com.example.chatapp.databinding.HomeFragmentBinding binding;
    private java.util.ArrayList<com.example.chatapp.chat.ChatMessage> conservation;
    private com.example.chatapp.adapter.AdapterRecentChat conservationAdapter;
    private java.util.ArrayList<com.example.chatapp.model.User> listUser;
    private com.example.chatapp.storage.Preferences preferences;
    private com.example.chatapp.adapter.AdapterUserOnline userOnlineAdapter;
    private java.lang.String token;
    
    public HomeFragment(@org.jetbrains.annotations.NotNull()
    com.example.chatapp.main.MainFragment mainFragment) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void loadImageUser() {
    }
    
    private final void getToken() {
    }
    
    private final void putToken() {
    }
    
    private final void setUpRecyclerView() {
    }
    
    private final void setUpRecyclerViewOnline() {
    }
    
    private final void getConservation() {
    }
    
    private final void getUserOnline() {
    }
    
    private final void onSearchUser() {
    }
    
    private final void swipeToDelete() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void showDialogForConservation(int position) {
    }
}