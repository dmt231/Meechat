package com.example.chatapp.chat;

import java.lang.System;

@kotlin.Suppress(names = {"NAME_SHADOWING"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010\'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020\u001fH\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\"\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010>H\u0017J\b\u0010?\u001a\u00020\u001fH\u0002J \u0010@\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\rH\u0002J\u0018\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u0002042\u0006\u0010$\u001a\u00020\nH\u0002J$\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\u001fH\u0016J\b\u0010N\u001a\u00020\u001fH\u0002J\b\u0010O\u001a\u00020\u001fH\u0002J\b\u0010P\u001a\u00020\u001fH\u0002J\b\u0010Q\u001a\u00020\u001fH\u0002J\b\u0010R\u001a\u00020\u001fH\u0002J\u0010\u0010S\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010T\u001a\u00020\u001fH\u0002J\u0010\u0010U\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020;H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0012j\b\u0012\u0004\u0012\u00020\n`\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006W"}, d2 = {"Lcom/example/chatapp/chat/ChatScreen;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/chatapp/adapter/AdapterChat;", "binding", "Lcom/example/chatapp/databinding/LayoutChatBinding;", "chatRepository", "Lcom/example/chatapp/repository/ChatRepository;", "colorRecent", "", "conversationId", "iconRecent", "Landroid/graphics/Bitmap;", "isImage", "", "lastTimeMessage", "listChat", "Ljava/util/ArrayList;", "Lcom/example/chatapp/chat/ChatMessage;", "Lkotlin/collections/ArrayList;", "listImage", "onStatusReceivedID", "preferences", "Lcom/example/chatapp/storage/Preferences;", "tokenUser", "user", "Lcom/example/chatapp/model/User;", "userRepository", "Lcom/example/chatapp/repository/UserRepository;", "back", "", "cancelImage", "checkForConversation", "checkNetwork", "customToastOffline", "message", "activity", "Landroid/app/Activity;", "encodeImage", "bitmap", "getBitMapImage", "image", "getChat", "getConversionName", "getDataUser", "getIconBitmap", "view", "Landroid/widget/ImageView;", "getStatusUser", "getTokenReceivedUser", "getUserPresent", "", "loadImageUser", "notificationForIcon", "notificationForImage", "notificationForMessage", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChangeStatusUser", "onChangeToChatSetting", "color", "icon", "onChangeToShareScreen", "type", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onSetUpRecyclerView", "onTextChanged", "pickImage", "sendChat", "sendIcon", "sendNotification", "setUpData", "showDialogForMessage", "position", "app_debug"})
public final class ChatScreen extends androidx.fragment.app.Fragment {
    private com.example.chatapp.databinding.LayoutChatBinding binding;
    private com.example.chatapp.model.User user;
    private com.example.chatapp.storage.Preferences preferences;
    private com.example.chatapp.adapter.AdapterChat adapter;
    private com.example.chatapp.repository.ChatRepository chatRepository;
    private com.example.chatapp.repository.UserRepository userRepository;
    private java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listChat;
    private java.util.ArrayList<java.lang.String> listImage;
    private java.lang.String conversationId;
    private boolean isImage = false;
    private java.lang.String tokenUser;
    private boolean onStatusReceivedID = false;
    private java.lang.String lastTimeMessage;
    private java.lang.String colorRecent = "#2E79F6";
    private android.graphics.Bitmap iconRecent;
    
    public ChatScreen() {
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final android.graphics.Bitmap getIconBitmap(android.widget.ImageView view) {
        return null;
    }
    
    private final void getTokenReceivedUser() {
    }
    
    private final void getDataUser() {
    }
    
    private final void setUpData() {
    }
    
    private final void loadImageUser() {
    }
    
    private final android.graphics.Bitmap getBitMapImage(java.lang.String image) {
        return null;
    }
    
    private final void back() {
    }
    
    private final long getUserPresent() {
        return 0L;
    }
    
    private final void onSetUpRecyclerView() {
    }
    
    private final void onTextChanged() {
    }
    
    private final void sendIcon() {
    }
    
    private final void sendChat() {
    }
    
    private final void getChat() {
    }
    
    private final void getConversionName() {
    }
    
    private final void checkForConversation() {
    }
    
    private final void getStatusUser() {
    }
    
    private final void onChangeStatusUser() {
    }
    
    private final java.lang.String encodeImage(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void pickImage() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    @java.lang.Deprecated()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void cancelImage() {
    }
    
    private final void sendNotification(java.lang.String message) {
    }
    
    private final void notificationForImage() {
    }
    
    private final void notificationForMessage() {
    }
    
    private final void notificationForIcon() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void showDialogForMessage(int position) {
    }
    
    private final void onChangeToShareScreen(long type, java.lang.String message) {
    }
    
    private final void onChangeToChatSetting(java.lang.String image, java.lang.String color, android.graphics.Bitmap icon) {
    }
    
    private final boolean checkNetwork() {
        return false;
    }
    
    private final void customToastOffline(java.lang.String message, android.app.Activity activity) {
    }
}