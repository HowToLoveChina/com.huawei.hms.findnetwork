package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.C0523e0;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.InterfaceC0399b, InterfaceC0415l, AdapterView.OnItemClickListener {

    /* renamed from: c */
    public static final int[] f1507c = {R.attr.background, R.attr.divider};

    /* renamed from: a */
    public MenuBuilder f1508a;

    /* renamed from: b */
    public int f1509b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0399b
    /* renamed from: a */
    public boolean mo2327a(C0411h c0411h) {
        return this.f1508a.m2349N(c0411h, 0);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l
    /* renamed from: b */
    public void mo2328b(MenuBuilder menuBuilder) {
        this.f1508a = menuBuilder;
    }

    public int getWindowAnimations() {
        return this.f1509b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        mo2327a((C0411h) getAdapter().getItem(i10));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, f1507c, i10, 0);
        if (c0523e0M2946v.m2965s(0)) {
            setBackgroundDrawable(c0523e0M2946v.m2953g(0));
        }
        if (c0523e0M2946v.m2965s(1)) {
            setDivider(c0523e0M2946v.m2953g(1));
        }
        c0523e0M2946v.m2966w();
    }
}
