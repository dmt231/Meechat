// Generated by view binder compiler. Do not edit!
package com.example.chatapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LoginBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnCreateAccount;

  @NonNull
  public final Button btnSignIn;

  @NonNull
  public final EditText emailInput;

  @NonNull
  public final FrameLayout loginPage;

  @NonNull
  public final TextInputEditText passwordInput;

  @NonNull
  public final TextInputLayout passwordInputLayout;

  @NonNull
  public final ProgressBar progressBarSignIn;

  private LoginBinding(@NonNull FrameLayout rootView, @NonNull Button btnCreateAccount,
      @NonNull Button btnSignIn, @NonNull EditText emailInput, @NonNull FrameLayout loginPage,
      @NonNull TextInputEditText passwordInput, @NonNull TextInputLayout passwordInputLayout,
      @NonNull ProgressBar progressBarSignIn) {
    this.rootView = rootView;
    this.btnCreateAccount = btnCreateAccount;
    this.btnSignIn = btnSignIn;
    this.emailInput = emailInput;
    this.loginPage = loginPage;
    this.passwordInput = passwordInput;
    this.passwordInputLayout = passwordInputLayout;
    this.progressBarSignIn = progressBarSignIn;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LoginBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCreateAccount;
      Button btnCreateAccount = ViewBindings.findChildViewById(rootView, id);
      if (btnCreateAccount == null) {
        break missingId;
      }

      id = R.id.btnSignIn;
      Button btnSignIn = ViewBindings.findChildViewById(rootView, id);
      if (btnSignIn == null) {
        break missingId;
      }

      id = R.id.emailInput;
      EditText emailInput = ViewBindings.findChildViewById(rootView, id);
      if (emailInput == null) {
        break missingId;
      }

      FrameLayout loginPage = (FrameLayout) rootView;

      id = R.id.passwordInput;
      TextInputEditText passwordInput = ViewBindings.findChildViewById(rootView, id);
      if (passwordInput == null) {
        break missingId;
      }

      id = R.id.passwordInputLayout;
      TextInputLayout passwordInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (passwordInputLayout == null) {
        break missingId;
      }

      id = R.id.progressBarSignIn;
      ProgressBar progressBarSignIn = ViewBindings.findChildViewById(rootView, id);
      if (progressBarSignIn == null) {
        break missingId;
      }

      return new LoginBinding((FrameLayout) rootView, btnCreateAccount, btnSignIn, emailInput,
          loginPage, passwordInput, passwordInputLayout, progressBarSignIn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
