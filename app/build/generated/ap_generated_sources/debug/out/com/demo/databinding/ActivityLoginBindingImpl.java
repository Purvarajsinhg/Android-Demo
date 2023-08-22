package com.demo.databinding;
import com.demo.R;
import com.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guidelineTop, 1);
        sViewsWithIds.put(R.id.txtHey, 2);
        sViewsWithIds.put(R.id.txtWelcome, 3);
        sViewsWithIds.put(R.id.txtInpLayoutEmail, 4);
        sViewsWithIds.put(R.id.edtEmail, 5);
        sViewsWithIds.put(R.id.txtInpLayoutPassword, 6);
        sViewsWithIds.put(R.id.edtPassword, 7);
        sViewsWithIds.put(R.id.txtForgotPass, 8);
        sViewsWithIds.put(R.id.txtLogin, 9);
        sViewsWithIds.put(R.id.txtOr, 10);
        sViewsWithIds.put(R.id.card, 11);
        sViewsWithIds.put(R.id.txtGoogle, 12);
        sViewsWithIds.put(R.id.txtCreateAct, 13);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.card.MaterialCardView) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (com.demo.view.CSEditextRegular) bindings[5]
            , (com.demo.view.CSEditextRegular) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[1]
            , (com.demo.view.CSTextViewRegular14Gray) bindings[13]
            , (com.demo.view.CSTextViewMediumGray) bindings[8]
            , (com.demo.view.CSButtonWhite) bindings[12]
            , (com.demo.view.CSTextViewMedium30Black) bindings[2]
            , (com.demo.view.CustomTextInputLayoutRegular) bindings[4]
            , (com.demo.view.CustomTextInputLayoutRegular) bindings[6]
            , (com.demo.view.CSButtonMedium16BlueGradient) bindings[9]
            , (com.demo.view.CSTextViewMedium14Gray) bindings[10]
            , (com.demo.view.CSTextViewRegular16Gray) bindings[3]
            );
        this.constraintMain.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}