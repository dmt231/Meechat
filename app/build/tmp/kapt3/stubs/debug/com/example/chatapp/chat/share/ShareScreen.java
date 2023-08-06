package com.example.chatapp.chat.share;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/chatapp/chat/share/ShareScreen;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/chatapp/adapter/AdapterContactShare;", "binding", "Lcom/example/chatapp/databinding/LayoutShareMessageBinding;", "chatRepository", "Lcom/example/chatapp/repository/ChatRepository;", "listUser", "Ljava/util/ArrayList;", "Lcom/example/chatapp/model/User;", "Lkotlin/collections/ArrayList;", "message", "", "repository", "Lcom/example/chatapp/repository/UserRepository;", "senderId", "", "Ljava/lang/Long;", "senderImage", "senderName", "typeMessage", "viewModel", "Lcom/example/chatapp/login/LoginViewModel;", "back", "", "checkForConservation", "receivedId", "receivedName", "receivedImage", "customToast", "getDataFromChatScreen", "loadUser", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "searchUser", "setUpRecyclerView", "app_debug"})
public final class ShareScreen extends androidx.fragment.app.Fragment {
    private com.example.chatapp.databinding.LayoutShareMessageBinding binding;
    private com.example.chatapp.adapter.AdapterContactShare adapter;
    private java.util.ArrayList<com.example.chatapp.model.User> listUser;
    private com.example.chatapp.login.LoginViewModel viewModel;
    private com.example.chatapp.repository.UserRepository repository;
    private java.lang.Long senderId;
    private java.lang.Long typeMessage;
    private java.lang.String message;
    private java.lang.String senderName;
    private java.lang.String senderImage;
    private com.example.chatapp.repository.ChatRepository chatRepository;
    
    public ShareScreen() {
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
    
    private final void getDataFromChatScreen() {
    }
    
    private final void loadUser() {
    }
    
    private final void searchUser() {
    }
    
    private final void customToast(java.lang.String message) {
    }
    
    private final void setUpRecyclerView() {
    }
    
    private final void back() {
    }
    
    private final void checkForConservation(long senderId, long receivedId, java.lang.String receivedName, java.lang.String receivedImage) {
    }
}