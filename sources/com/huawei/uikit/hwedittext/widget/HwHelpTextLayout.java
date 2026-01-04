package com.huawei.uikit.hwedittext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.C0669j;
import com.huawei.uikit.hwedittext.C8712R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes7.dex */
public class HwHelpTextLayout extends LinearLayout {

    /* renamed from: h */
    private static final int f42747h = 3;

    /* renamed from: a */
    private HwWidgetStyle f42748a;

    /* renamed from: b */
    private EditText f42749b;

    /* renamed from: c */
    private TextView f42750c;

    /* renamed from: d */
    private CharSequence f42751d;

    /* renamed from: e */
    private CharSequence f42752e;

    /* renamed from: f */
    private CharSequence f42753f;

    /* renamed from: g */
    private int f42754g;
    protected HwShapeMode mHwShapMode;

    public HwHelpTextLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private static Context m54648a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8712R.style.Theme_Emui_HwEditText);
    }

    public static HwHelpTextLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwHelpTextLayout.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwHelpTextLayout.class);
        if (objInstantiate instanceof HwHelpTextLayout) {
            return (HwHelpTextLayout) objInstantiate;
        }
        return null;
    }

    public EditText getEditText() {
        return this.f42749b;
    }

    public CharSequence getHelp() {
        return this.f42750c.getText();
    }

    public CharSequence getHint() {
        return this.f42749b.getHint();
    }

    public CharSequence getText() {
        return this.f42749b.getText();
    }

    public TextView getTextView() {
        return this.f42750c;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setHelp(CharSequence charSequence) {
        this.f42750c.setText(charSequence);
    }

    public void setHint(CharSequence charSequence) {
        this.f42749b.setHint(charSequence);
    }

    public void setText(CharSequence charSequence) {
        this.f42749b.setText(charSequence);
    }

    public HwHelpTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8712R.attr.hwHelpTextStyle);
    }

    /* renamed from: a */
    private void m54651a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8712R.styleable.HwHelpTextLayout, i10, C8712R.style.Widget_Emui_HwHelpTextLayout);
        this.mHwShapMode = HwShapeMode.values()[typedArrayObtainStyledAttributes.getInt(C8712R.styleable.HwHelpTextLayout_hwShapeMode, 0)];
        this.f42748a = HwWidgetStyle.values()[typedArrayObtainStyledAttributes.getInt(C8712R.styleable.HwHelpTextLayout_hwWidgetStyle, 0)];
        this.f42751d = typedArrayObtainStyledAttributes.getString(C8712R.styleable.HwHelpTextLayout_hwHint);
        this.f42752e = typedArrayObtainStyledAttributes.getString(C8712R.styleable.HwHelpTextLayout_hwText);
        this.f42753f = typedArrayObtainStyledAttributes.getString(C8712R.styleable.HwHelpTextLayout_hwHelp);
        this.f42754g = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwHelpTextLayout_hwHelpTextAppearance, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public HwHelpTextLayout(Context context, AttributeSet attributeSet, int i10) {
        super(m54648a(context, i10), attributeSet, i10);
        m54651a(super.getContext(), attributeSet, i10);
        HwShapeMode hwShapeMode = this.mHwShapMode;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            m54650a(C8712R.layout.hwedittext_help_text_layout_bubble, C8712R.layout.hwedittext_help_text_layout_bubble_dark, C8712R.layout.hwedittext_help_text_layout_bubble_translucent);
            return;
        }
        if (hwShapeMode == HwShapeMode.LINEAR) {
            m54650a(C8712R.layout.hwedittext_help_text_layout_linear, C8712R.layout.hwedittext_help_text_layout_linear_dark, C8712R.layout.hwedittext_help_text_layout_linear_translucent);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            m54650a(C8712R.layout.hwedittext_help_text_layout_bubble_white, C8712R.layout.hwedittext_help_text_layout_bubble_white_dark, C8712R.layout.hwedittext_help_text_layout_bubble_white_translucent);
        } else {
            m54650a(C8712R.layout.hwedittext_help_text_layout_space, C8712R.layout.hwedittext_help_text_layout_space_dark, C8712R.layout.hwedittext_help_text_layout_space_translucent);
        }
    }

    /* renamed from: a */
    private void m54649a(int i10) {
        View.inflate(getContext(), i10, this);
        EditText editText = (EditText) findViewById(C8712R.id.hwedittext_edit);
        this.f42749b = editText;
        if (editText != null) {
            editText.setHint(this.f42751d);
            this.f42749b.setText(this.f42752e);
        }
        TextView textView = (TextView) findViewById(C8712R.id.hwedittext_text_assist);
        this.f42750c = textView;
        if (textView != null) {
            textView.setText(this.f42753f);
            C0669j.m4080n(this.f42750c, this.f42754g);
        }
    }

    /* renamed from: a */
    private void m54650a(int i10, int i11, int i12) {
        HwWidgetStyle hwWidgetStyle = this.f42748a;
        if (hwWidgetStyle == HwWidgetStyle.LIGHT) {
            m54649a(i10);
        } else if (hwWidgetStyle == HwWidgetStyle.DARK) {
            m54649a(i11);
        } else {
            m54649a(i12);
        }
    }
}
