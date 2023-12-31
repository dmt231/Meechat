package com.example.chatapp.chat.info;

import java.lang.System;

@kotlin.Suppress(names = {"NAME_SHADOWING"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u0006,"}, d2 = {"Lcom/example/chatapp/chat/info/InfoChat;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/chatapp/databinding/DialogSettingChatBinding;", "chatRepository", "Lcom/example/chatapp/repository/ChatRepository;", "colorTheme", "", "conversationId", "icon", "Landroid/graphics/Bitmap;", "image", "preferences", "Lcom/example/chatapp/storage/Preferences;", "receivedId", "", "Ljava/lang/Long;", "changeColorThem", "", "color", "changeIcon", "encodeImage", "bitmap", "getBitMapImage", "getConversionName", "getData", "getIconBitmap", "view", "Landroid/widget/ImageView;", "onChangeToNickname", "onChangeToStorage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setUpData", "showDialogForChooseIcon", "showDialogForChooseThemColor", "app_debug"})
public final class InfoChat extends androidx.fragment.app.Fragment {
    private com.example.chatapp.databinding.DialogSettingChatBinding binding;
    private com.example.chatapp.storage.Preferences preferences;
    private com.example.chatapp.repository.ChatRepository chatRepository;
    private java.lang.String colorTheme;
    private android.graphics.Bitmap icon;
    private java.lang.String image;
    private java.lang.String conversationId;
    private java.lang.Long receivedId;
    
    public InfoChat() {
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
    
    private final void getConversionName() {
    }
    
    private final void onChangeToNickname() {
    }
    
    private final void getData() {
    }
    
    private final void setUpData() {
    }
    
    private final android.graphics.Bitmap getBitMapImage(java.lang.String image) {
        return null;
    }
    
    private final void showDialogForChooseIcon() {
    }
    
    private final void showDialogForChooseThemColor() {
    }
    
    private final android.graphics.Bitmap getIconBitmap(android.widget.ImageView view) {
        return null;
    }
    
    private final java.lang.String encodeImage(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void changeIcon(java.lang.String icon) {
    }
    
    private final void changeColorThem(java.lang.String color) {
    }
    
    private final void onChangeToStorage() {
    }
}