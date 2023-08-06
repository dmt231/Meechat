// Generated by view binder compiler. Do not edit!
package com.example.chatapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatapp.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogSettingChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RelativeLayout Emoji;

  @NonNull
  public final RelativeLayout MediaStore;

  @NonNull
  public final RelativeLayout Nickname;

  @NonNull
  public final RelativeLayout Theme;

  @NonNull
  public final ImageView btnBack;

  @NonNull
  public final RoundedImageView imageSettingChat;

  @NonNull
  public final TextView nameSettingChat;

  @NonNull
  public final RoundedImageView recentEmojiPicked;

  @NonNull
  public final ImageView recentThemePicked;

  private DialogSettingChatBinding(@NonNull ConstraintLayout rootView,
      @NonNull RelativeLayout Emoji, @NonNull RelativeLayout MediaStore,
      @NonNull RelativeLayout Nickname, @NonNull RelativeLayout Theme, @NonNull ImageView btnBack,
      @NonNull RoundedImageView imageSettingChat, @NonNull TextView nameSettingChat,
      @NonNull RoundedImageView recentEmojiPicked, @NonNull ImageView recentThemePicked) {
    this.rootView = rootView;
    this.Emoji = Emoji;
    this.MediaStore = MediaStore;
    this.Nickname = Nickname;
    this.Theme = Theme;
    this.btnBack = btnBack;
    this.imageSettingChat = imageSettingChat;
    this.nameSettingChat = nameSettingChat;
    this.recentEmojiPicked = recentEmojiPicked;
    this.recentThemePicked = recentThemePicked;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogSettingChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogSettingChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_setting_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogSettingChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Emoji;
      RelativeLayout Emoji = ViewBindings.findChildViewById(rootView, id);
      if (Emoji == null) {
        break missingId;
      }

      id = R.id.MediaStore;
      RelativeLayout MediaStore = ViewBindings.findChildViewById(rootView, id);
      if (MediaStore == null) {
        break missingId;
      }

      id = R.id.Nickname;
      RelativeLayout Nickname = ViewBindings.findChildViewById(rootView, id);
      if (Nickname == null) {
        break missingId;
      }

      id = R.id.Theme;
      RelativeLayout Theme = ViewBindings.findChildViewById(rootView, id);
      if (Theme == null) {
        break missingId;
      }

      id = R.id.btnBack;
      ImageView btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.imageSettingChat;
      RoundedImageView imageSettingChat = ViewBindings.findChildViewById(rootView, id);
      if (imageSettingChat == null) {
        break missingId;
      }

      id = R.id.nameSettingChat;
      TextView nameSettingChat = ViewBindings.findChildViewById(rootView, id);
      if (nameSettingChat == null) {
        break missingId;
      }

      id = R.id.recentEmojiPicked;
      RoundedImageView recentEmojiPicked = ViewBindings.findChildViewById(rootView, id);
      if (recentEmojiPicked == null) {
        break missingId;
      }

      id = R.id.recentThemePicked;
      ImageView recentThemePicked = ViewBindings.findChildViewById(rootView, id);
      if (recentThemePicked == null) {
        break missingId;
      }

      return new DialogSettingChatBinding((ConstraintLayout) rootView, Emoji, MediaStore, Nickname,
          Theme, btnBack, imageSettingChat, nameSettingChat, recentEmojiPicked, recentThemePicked);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}