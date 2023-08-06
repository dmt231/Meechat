// Generated by view binder compiler. Do not edit!
package com.example.chatapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGetStartedBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnStart;

  @NonNull
  public final TextView txtConnect;

  @NonNull
  public final TextView txtContent;

  private ActivityGetStartedBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnStart,
      @NonNull TextView txtConnect, @NonNull TextView txtContent) {
    this.rootView = rootView;
    this.btnStart = btnStart;
    this.txtConnect = txtConnect;
    this.txtContent = txtContent;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGetStartedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGetStartedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_get_started, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGetStartedBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnStart;
      Button btnStart = ViewBindings.findChildViewById(rootView, id);
      if (btnStart == null) {
        break missingId;
      }

      id = R.id.txtConnect;
      TextView txtConnect = ViewBindings.findChildViewById(rootView, id);
      if (txtConnect == null) {
        break missingId;
      }

      id = R.id.txtContent;
      TextView txtContent = ViewBindings.findChildViewById(rootView, id);
      if (txtContent == null) {
        break missingId;
      }

      return new ActivityGetStartedBinding((ConstraintLayout) rootView, btnStart, txtConnect,
          txtContent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
