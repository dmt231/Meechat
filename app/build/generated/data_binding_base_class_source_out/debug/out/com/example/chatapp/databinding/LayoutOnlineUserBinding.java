// Generated by view binder compiler. Do not edit!
package com.example.chatapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatapp.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutOnlineUserBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RoundedImageView imageOnline;

  @NonNull
  public final TextView nameUserOnline;

  private LayoutOnlineUserBinding(@NonNull RelativeLayout rootView,
      @NonNull RoundedImageView imageOnline, @NonNull TextView nameUserOnline) {
    this.rootView = rootView;
    this.imageOnline = imageOnline;
    this.nameUserOnline = nameUserOnline;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutOnlineUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutOnlineUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_online_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutOnlineUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_online;
      RoundedImageView imageOnline = ViewBindings.findChildViewById(rootView, id);
      if (imageOnline == null) {
        break missingId;
      }

      id = R.id.nameUserOnline;
      TextView nameUserOnline = ViewBindings.findChildViewById(rootView, id);
      if (nameUserOnline == null) {
        break missingId;
      }

      return new LayoutOnlineUserBinding((RelativeLayout) rootView, imageOnline, nameUserOnline);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
