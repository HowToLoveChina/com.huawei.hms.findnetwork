package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.C0523e0;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: a */
    public final CharSequence f8696a;

    /* renamed from: b */
    public final Drawable f8697b;

    /* renamed from: c */
    public final int f8698c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0523e0 c0523e0M2945u = C0523e0.m2945u(context, attributeSet, R$styleable.TabItem);
        this.f8696a = c0523e0M2945u.m2962p(R$styleable.TabItem_android_text);
        this.f8697b = c0523e0M2945u.m2953g(R$styleable.TabItem_android_icon);
        this.f8698c = c0523e0M2945u.m2960n(R$styleable.TabItem_android_layout, 0);
        c0523e0M2945u.m2966w();
    }
}
