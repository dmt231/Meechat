// Generated by view binder compiler. Do not edit!
package com.example.chatapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class LayoutReceivedImageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageReceived;

  @NonNull
  public final RoundedImageView imgProfileReceivedImage;

  @NonNull
  public final TextView timeImageReceived;

  private LayoutReceivedImageBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageReceived, @NonNull RoundedImageView imgProfileReceivedImage,
      @NonNull TextView timeImageReceived) {
    this.rootView = rootView;
    this.imageReceived = imageReceived;
    this.imgProfileReceivedImage = imgProfileReceivedImage;
    this.timeImageReceived = timeImageReceived;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutReceivedImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutReceivedImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_received_image, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutReceivedImageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageReceived;
      ImageView imageReceived = ViewBindings.findChildViewById(rootView, id);
      if (imageReceived == null) {
        break missingId;
      }

      id = R.id.imgProfileReceivedImage;
      RoundedImageView imgProfileReceivedImage = ViewBindings.findChildViewById(rootView, id);
      if (imgProfileReceivedImage == null) {
        break missingId;
      }

      id = R.id.timeImageReceived;
      TextView timeImageReceived = ViewBindings.findChildViewById(rootView, id);
      if (timeImageReceived == null) {
        break missingId;
      }

      return new LayoutReceivedImageBinding((ConstraintLayout) rootView, imageReceived,
          imgProfileReceivedImage, timeImageReceived);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
