package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.C1788s;
import com.google.android.material.tabs.TabLayout;
import p666u2.C13110a;

/* renamed from: com.google.android.material.tabs.c */
/* loaded from: classes.dex */
public class C1852c {
    /* renamed from: a */
    public static RectF m11148a(TabLayout tabLayout, View view) {
        return view == null ? new RectF() : (tabLayout.m11087y() || !(view instanceof TabLayout.TabView)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : m11149b((TabLayout.TabView) view, 24);
    }

    /* renamed from: b */
    public static RectF m11149b(TabLayout.TabView tabView, int i10) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int iM10782c = (int) C1788s.m10782c(tabView.getContext(), i10);
        if (contentWidth < iM10782c) {
            contentWidth = iM10782c;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i11 = contentWidth / 2;
        return new RectF(left - i11, top - (contentHeight / 2), i11 + left, top + (left / 2));
    }

    /* renamed from: c */
    public void m11150c(TabLayout tabLayout, View view, Drawable drawable) {
        RectF rectFM11148a = m11148a(tabLayout, view);
        drawable.setBounds((int) rectFM11148a.left, drawable.getBounds().top, (int) rectFM11148a.right, drawable.getBounds().bottom);
    }

    /* renamed from: d */
    public void mo11147d(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        RectF rectFM11148a = m11148a(tabLayout, view);
        RectF rectFM11148a2 = m11148a(tabLayout, view2);
        drawable.setBounds(C13110a.m78886c((int) rectFM11148a.left, (int) rectFM11148a2.left, f10), drawable.getBounds().top, C13110a.m78886c((int) rectFM11148a.right, (int) rectFM11148a2.right, f10), drawable.getBounds().bottom);
    }
}
