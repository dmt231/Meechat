package com.example.chatapp.databinding;
import com.example.chatapp.R;
import com.example.chatapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CustomRecyclerShareBindingImpl extends CustomRecyclerShareBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imgContactShare, 2);
        sViewsWithIds.put(R.id.buttonShare, 3);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CustomRecyclerShareBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private CustomRecyclerShareBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[3]
            , (com.makeramen.roundedimageview.RoundedImageView) bindings[2]
            , (android.widget.RelativeLayout) bindings[0]
            , (android.widget.TextView) bindings[1]
            );
        this.layoutRecyclerShare.setTag(null);
        this.nameContactShare.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.UserShare == variableId) {
            setUserShare((com.example.chatapp.model.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUserShare(@Nullable com.example.chatapp.model.User UserShare) {
        this.mUserShare = UserShare;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.UserShare);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String userShareUsername = null;
        com.example.chatapp.model.User userShare = mUserShare;

        if ((dirtyFlags & 0x3L) != 0) {



                if (userShare != null) {
                    // read UserShare.username
                    userShareUsername = userShare.getUsername();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameContactShare, userShareUsername);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): UserShare
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}