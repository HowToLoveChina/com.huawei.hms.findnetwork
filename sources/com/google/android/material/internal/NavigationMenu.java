package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        C0411h c0411h = (C0411h) mo2362a(i10, i11, i12, charSequence);
        C1778i c1778i = new C1778i(m2391w(), this, c0411h);
        c0411h.m2491x(c1778i);
        return c1778i;
    }
}
