// Generated by view binder compiler. Do not edit!
package com.example.chatapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutSelectColorBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnCancel;

  @NonNull
  public final Button btnSelect;

  @NonNull
  public final ImageView colorBackground;

  @NonNull
  public final ImageView colorDarkGray;

  @NonNull
  public final ImageView colorGreen;

  @NonNull
  public final ImageView colorLightBlue;

  @NonNull
  public final ImageView colorLightBrown;

  @NonNull
  public final ImageView colorLightGray;

  @NonNull
  public final ImageView colorOrange;

  @NonNull
  public final ImageView colorPink;

  @NonNull
  public final ImageView colorRed;

  @NonNull
  public final ImageView colorYellow;

  @NonNull
  public final ImageView currentTheme;

  @NonNull
  public final View line;

  @NonNull
  public final View line2;

  private LayoutSelectColorBinding(@NonNull RelativeLayout rootView, @NonNull Button btnCancel,
      @NonNull Button btnSelect, @NonNull ImageView colorBackground,
      @NonNull ImageView colorDarkGray, @NonNull ImageView colorGreen,
      @NonNull ImageView colorLightBlue, @NonNull ImageView colorLightBrown,
      @NonNull ImageView colorLightGray, @NonNull ImageView colorOrange,
      @NonNull ImageView colorPink, @NonNull ImageView colorRed, @NonNull ImageView colorYellow,
      @NonNull ImageView currentTheme, @NonNull View line, @NonNull View line2) {
    this.rootView = rootView;
    this.btnCancel = btnCancel;
    this.btnSelect = btnSelect;
    this.colorBackground = colorBackground;
    this.colorDarkGray = colorDarkGray;
    this.colorGreen = colorGreen;
    this.colorLightBlue = colorLightBlue;
    this.colorLightBrown = colorLightBrown;
    this.colorLightGray = colorLightGray;
    this.colorOrange = colorOrange;
    this.colorPink = colorPink;
    this.colorRed = colorRed;
    this.colorYellow = colorYellow;
    this.currentTheme = currentTheme;
    this.line = line;
    this.line2 = line2;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutSelectColorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutSelectColorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_select_color, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutSelectColorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCancel;
      Button btnCancel = ViewBindings.findChildViewById(rootView, id);
      if (btnCancel == null) {
        break missingId;
      }

      id = R.id.btnSelect;
      Button btnSelect = ViewBindings.findChildViewById(rootView, id);
      if (btnSelect == null) {
        break missingId;
      }

      id = R.id.colorBackground;
      ImageView colorBackground = ViewBindings.findChildViewById(rootView, id);
      if (colorBackground == null) {
        break missingId;
      }

      id = R.id.colorDarkGray;
      ImageView colorDarkGray = ViewBindings.findChildViewById(rootView, id);
      if (colorDarkGray == null) {
        break missingId;
      }

      id = R.id.colorGreen;
      ImageView colorGreen = ViewBindings.findChildViewById(rootView, id);
      if (colorGreen == null) {
        break missingId;
      }

      id = R.id.colorLightBlue;
      ImageView colorLightBlue = ViewBindings.findChildViewById(rootView, id);
      if (colorLightBlue == null) {
        break missingId;
      }

      id = R.id.colorLightBrown;
      ImageView colorLightBrown = ViewBindings.findChildViewById(rootView, id);
      if (colorLightBrown == null) {
        break missingId;
      }

      id = R.id.colorLightGray;
      ImageView colorLightGray = ViewBindings.findChildViewById(rootView, id);
      if (colorLightGray == null) {
        break missingId;
      }

      id = R.id.colorOrange;
      ImageView colorOrange = ViewBindings.findChildViewById(rootView, id);
      if (colorOrange == null) {
        break missingId;
      }

      id = R.id.colorPink;
      ImageView colorPink = ViewBindings.findChildViewById(rootView, id);
      if (colorPink == null) {
        break missingId;
      }

      id = R.id.colorRed;
      ImageView colorRed = ViewBindings.findChildViewById(rootView, id);
      if (colorRed == null) {
        break missingId;
      }

      id = R.id.colorYellow;
      ImageView colorYellow = ViewBindings.findChildViewById(rootView, id);
      if (colorYellow == null) {
        break missingId;
      }

      id = R.id.currentTheme;
      ImageView currentTheme = ViewBindings.findChildViewById(rootView, id);
      if (currentTheme == null) {
        break missingId;
      }

      id = R.id.line;
      View line = ViewBindings.findChildViewById(rootView, id);
      if (line == null) {
        break missingId;
      }

      id = R.id.line2;
      View line2 = ViewBindings.findChildViewById(rootView, id);
      if (line2 == null) {
        break missingId;
      }

      return new LayoutSelectColorBinding((RelativeLayout) rootView, btnCancel, btnSelect,
          colorBackground, colorDarkGray, colorGreen, colorLightBlue, colorLightBrown,
          colorLightGray, colorOrange, colorPink, colorRed, colorYellow, currentTheme, line, line2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
