package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.MenuBuilder;

/* renamed from: com.google.android.material.navigation.a */
/* loaded from: classes.dex */
public final class C1804a extends MenuBuilder {

    /* renamed from: B */
    public final Class<?> f8517B;

    /* renamed from: C */
    public final int f8518C;

    public C1804a(Context context, Class<?> cls, int i10) {
        super(context);
        this.f8517B = cls;
        this.f8518C = i10;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: a */
    public MenuItem mo2362a(int i10, int i11, int i12, CharSequence charSequence) {
        if (size() + 1 <= this.f8518C) {
            m2377h0();
            MenuItem menuItemMo2362a = super.mo2362a(i10, i11, i12, charSequence);
            if (menuItemMo2362a instanceof C0411h) {
                ((C0411h) menuItemMo2362a).m2487t(true);
            }
            m2375g0();
            return menuItemMo2362a;
        }
        String simpleName = this.f8517B.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.f8518C + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f8517B.getSimpleName() + " does not support submenus");
    }
}
