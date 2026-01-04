package com.huawei.uikit.hwedittext.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.C0669j;
import com.huawei.uikit.hwedittext.C8712R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes7.dex */
public class HwErrorTipTextLayout extends RelativeLayout {

    /* renamed from: k */
    private static final String f42731k = "HwErrorTipTextLayout";

    /* renamed from: l */
    private static final int f42732l = 3;

    /* renamed from: m */
    private static final int f42733m = 200;

    /* renamed from: a */
    private boolean f42734a;

    /* renamed from: b */
    private int f42735b;

    /* renamed from: c */
    private int f42736c;

    /* renamed from: d */
    private int f42737d;

    /* renamed from: e */
    private HwShapeMode f42738e;

    /* renamed from: f */
    private int f42739f;

    /* renamed from: g */
    private int f42740g;

    /* renamed from: h */
    private int f42741h;

    /* renamed from: i */
    private int f42742i;

    /* renamed from: j */
    private LinearLayout f42743j;
    protected EditText mEditText;
    protected int mErrorTextAppearance;
    protected TextView mErrorView;

    public class aauaf extends View.AccessibilityDelegate {
        private aauaf() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (view == null || accessibilityEvent == null) {
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(HwErrorTipTextLayout.class.getSimpleName());
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public /* synthetic */ aauaf(HwErrorTipTextLayout hwErrorTipTextLayout, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bzrwd extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boolean f42745a;

        public bzrwd(boolean z10) {
            this.f42745a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            HwErrorTipTextLayout.this.setBackground(this.f42745a);
            HwErrorTipTextLayout.this.mErrorView.setAlpha(this.f42745a ? 1.0f : 0.0f);
            HwErrorTipTextLayout.this.mErrorView.setVisibility(this.f42745a ? 0 : 8);
        }
    }

    public HwErrorTipTextLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private static Context m54646a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8712R.style.Theme_Emui_HwEditText);
    }

    public static HwErrorTipTextLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwErrorTipTextLayout.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwErrorTipTextLayout.class);
        if (objInstantiate instanceof HwErrorTipTextLayout) {
            return (HwErrorTipTextLayout) objInstantiate;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, updateEditTextMargin(layoutParams));
        }
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public CharSequence getError() {
        TextView textView = this.mErrorView;
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    public CharSequence getHint() {
        EditText editText = this.mEditText;
        if (editText == null) {
            return null;
        }
        return editText.getHint();
    }

    public void initErrorView() throws Resources.NotFoundException {
        TextView textView = new TextView(getContext());
        this.mErrorView = textView;
        textView.setVisibility(8);
        this.mErrorView.setPaddingRelative(this.mEditText.getPaddingLeft(), getResources().getDimensionPixelSize(C8712R.dimen.hwedittext_dimens_text_margin_fifth), this.mEditText.getPaddingRight(), 0);
        C0669j.m4080n(this.mErrorView, this.mErrorTextAppearance);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.mEditText.getId());
        this.mErrorView.setLayoutParams(layoutParams);
        addView(this.mErrorView);
    }

    public boolean isErrorEnabled() {
        return this.f42734a;
    }

    public void setBackground(boolean z10) {
        EditText editText = this.mEditText;
        if (editText == null || this.mErrorView == null) {
            return;
        }
        HwShapeMode hwShapeMode = this.f42738e;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            editText.setBackgroundResource(z10 ? this.f42735b : this.f42739f);
            return;
        }
        if (hwShapeMode == HwShapeMode.LINEAR) {
            editText.setBackgroundResource(z10 ? this.f42737d : this.f42741h);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            editText.setBackgroundResource(z10 ? this.f42736c : this.f42740g);
        } else {
            editText.setBackgroundResource(z10 ? this.f42737d : this.f42742i);
        }
    }

    public void setEditText(EditText editText) throws Resources.NotFoundException {
        if (this.mEditText != null) {
            return;
        }
        this.mEditText = editText;
        this.mEditText.setImeOptions(editText.getImeOptions() | 33554432);
        HwShapeMode hwShapeMode = this.f42738e;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            this.mEditText.setBackgroundResource(this.f42739f);
        } else if (hwShapeMode == HwShapeMode.LINEAR) {
            this.mEditText.setBackgroundResource(this.f42741h);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            this.mEditText.setBackgroundResource(this.f42740g);
        } else {
            this.mEditText.setBackgroundResource(this.f42742i);
        }
        initErrorView();
    }

    public void setError(CharSequence charSequence) {
        if (this.mEditText == null || this.mErrorView == null || !this.f42734a) {
            return;
        }
        boolean z10 = !TextUtils.isEmpty(charSequence);
        this.mErrorView.setText(charSequence);
        this.mErrorView.animate().setInterpolator(new LinearInterpolator()).setDuration(200L).alpha(z10 ? 1.0f : 0.0f).setListener(new bzrwd(z10)).start();
        sendAccessibilityEvent(2048);
    }

    public void setErrorEnabled(boolean z10) {
        TextView textView;
        if (z10 == this.f42734a || (textView = this.mErrorView) == null) {
            return;
        }
        textView.setAlpha(z10 ? 1.0f : 0.0f);
        this.mErrorView.setVisibility(z10 ? 0 : 8);
        this.f42734a = z10;
    }

    public void setHint(CharSequence charSequence) {
        EditText editText = this.mEditText;
        if (editText == null) {
            return;
        }
        editText.setHint(charSequence);
        sendAccessibilityEvent(2048);
    }

    public ViewGroup.LayoutParams updateEditTextMargin(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null ? new RelativeLayout.LayoutParams(layoutParams) : generateDefaultLayoutParams();
    }

    public HwErrorTipTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8712R.attr.hwErrorTextStyle);
    }

    /* renamed from: a */
    private void m54647a(Context context, AttributeSet attributeSet, int i10) {
        setAddStatesFromChildren(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8712R.styleable.HwErrorTipTextLayout, i10, C8712R.style.Widget_Emui_HwErrorTipTextLayout);
        this.f42739f = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwEditTextBg, 0);
        this.f42740g = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwEditTextBgWhite, 0);
        this.f42741h = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwLinearEditBg, 0);
        this.f42742i = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwSpaceEditBg, 0);
        this.f42735b = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwErrorResBg, 0);
        this.f42736c = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwErrorResBgWhite, 0);
        this.mErrorTextAppearance = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwErrorTextAppearance, 0);
        this.f42737d = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwErrorTipTextLayout_hwErrorLinearEditBg, 0);
        this.f42734a = typedArrayObtainStyledAttributes.getBoolean(C8712R.styleable.HwErrorTipTextLayout_hwErrorEnabled, true);
        this.f42738e = HwShapeMode.values()[typedArrayObtainStyledAttributes.getInt(C8712R.styleable.HwErrorTipTextLayout_hwShapeMode, 0)];
        typedArrayObtainStyledAttributes.recycle();
        setAccessibilityDelegate(new aauaf(this, null));
    }

    public HwErrorTipTextLayout(Context context, AttributeSet attributeSet, int i10) {
        super(m54646a(context, i10), attributeSet, i10);
        m54647a(super.getContext(), attributeSet, i10);
    }
}
