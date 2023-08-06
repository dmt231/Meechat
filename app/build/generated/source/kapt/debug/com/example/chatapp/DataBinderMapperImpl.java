package com.example.chatapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.chatapp.databinding.CustomRecyclerShareBindingImpl;
import com.example.chatapp.databinding.LayoutRecentBindingImpl;
import com.example.chatapp.databinding.LayoutRecyclerContactBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CUSTOMRECYCLERSHARE = 1;

  private static final int LAYOUT_LAYOUTRECENT = 2;

  private static final int LAYOUT_LAYOUTRECYCLERCONTACT = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.chatapp.R.layout.custom_recycler_share, LAYOUT_CUSTOMRECYCLERSHARE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.chatapp.R.layout.layout_recent, LAYOUT_LAYOUTRECENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.chatapp.R.layout.layout_recycler_contact, LAYOUT_LAYOUTRECYCLERCONTACT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CUSTOMRECYCLERSHARE: {
          if ("layout/custom_recycler_share_0".equals(tag)) {
            return new CustomRecyclerShareBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for custom_recycler_share is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTRECENT: {
          if ("layout/layout_recent_0".equals(tag)) {
            return new LayoutRecentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_recent is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTRECYCLERCONTACT: {
          if ("layout/layout_recycler_contact_0".equals(tag)) {
            return new LayoutRecyclerContactBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_recycler_contact is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(1, "ChatRecent");
      sKeys.put(2, "UserContact");
      sKeys.put(3, "UserShare");
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/custom_recycler_share_0", com.example.chatapp.R.layout.custom_recycler_share);
      sKeys.put("layout/layout_recent_0", com.example.chatapp.R.layout.layout_recent);
      sKeys.put("layout/layout_recycler_contact_0", com.example.chatapp.R.layout.layout_recycler_contact);
    }
  }
}
