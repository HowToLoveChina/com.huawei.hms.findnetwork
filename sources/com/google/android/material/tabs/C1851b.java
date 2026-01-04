package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import p666u2.C13110a;

/* renamed from: com.google.android.material.tabs.b */
/* loaded from: classes.dex */
public class C1851b extends C1852c {
    @Override // com.google.android.material.tabs.C1852c
    /* renamed from: d */
    public void mo11147d(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        if (f10 >= 0.5f) {
            view = view2;
        }
        RectF rectFM11148a = C1852c.m11148a(tabLayout, view);
        float fM78885b = f10 < 0.5f ? C13110a.m78885b(1.0f, 0.0f, 0.0f, 0.5f, f10) : C13110a.m78885b(0.0f, 1.0f, 0.5f, 1.0f, f10);
        drawable.setBounds((int) rectFM11148a.left, drawable.getBounds().top, (int) rectFM11148a.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (fM78885b * 255.0f));
    }
}
