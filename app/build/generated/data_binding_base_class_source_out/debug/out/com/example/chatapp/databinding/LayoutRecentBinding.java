// Generated by data binding compiler. Do not edit!
package com.example.chatapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.chatapp.R;
import com.example.chatapp.chat.ChatMessage;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayoutRecentBinding extends ViewDataBinding {
  @NonNull
  public final RoundedImageView imgContact;

  @NonNull
  public final RelativeLayout layoutRecyclerRecent;

  @NonNull
  public final TextView nameContact;

  @NonNull
  public final TextView textRecent;

  @Bindable
  protected ChatMessage mChatRecent;

  protected LayoutRecentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RoundedImageView imgContact, RelativeLayout layoutRecyclerRecent, TextView nameContact,
      TextView textRecent) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imgContact = imgContact;
    this.layoutRecyclerRecent = layoutRecyclerRecent;
    this.nameContact = nameContact;
    this.textRecent = textRecent;
  }

  public abstract void setChatRecent(@Nullable ChatMessage ChatRecent);

  @Nullable
  public ChatMessage getChatRecent() {
    return mChatRecent;
  }

  @NonNull
  public static LayoutRecentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_recent, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutRecentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutRecentBinding>inflateInternal(inflater, R.layout.layout_recent, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutRecentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_recent, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutRecentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutRecentBinding>inflateInternal(inflater, R.layout.layout_recent, null, false, component);
  }

  public static LayoutRecentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LayoutRecentBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutRecentBinding)bind(component, view, R.layout.layout_recent);
  }
}
