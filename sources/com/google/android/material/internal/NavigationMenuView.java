package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements InterfaceC0415l {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l
    /* renamed from: b */
    public void mo2328b(MenuBuilder menuBuilder) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
