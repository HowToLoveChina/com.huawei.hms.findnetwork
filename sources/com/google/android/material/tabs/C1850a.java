package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import p666u2.C13110a;

/* renamed from: com.google.android.material.tabs.a */
/* loaded from: classes.dex */
public class C1850a extends C1852c {
    /* renamed from: e */
    public static float m11145e(float f10) {
        return (float) (1.0d - Math.cos((f10 * 3.141592653589793d) / 2.0d));
    }

    /* renamed from: f */
    public static float m11146f(float f10) {
        return (float) Math.sin((f10 * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.C1852c
    /* renamed from: d */
    public void mo11147d(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        float fM11146f;
        float fM11145e;
        RectF rectFM11148a = C1852c.m11148a(tabLayout, view);
        RectF rectFM11148a2 = C1852c.m11148a(tabLayout, view2);
        if (rectFM11148a.left < rectFM11148a2.left) {
            fM11146f = m11145e(f10);
            fM11145e = m11146f(f10);
        } else {
            fM11146f = m11146f(f10);
            fM11145e = m11145e(f10);
        }
        drawable.setBounds(C13110a.m78886c((int) rectFM11148a.left, (int) rectFM11148a2.left, fM11146f), drawable.getBounds().top, C13110a.m78886c((int) rectFM11148a.right, (int) rectFM11148a2.right, fM11145e), drawable.getBounds().bottom);
    }
}
