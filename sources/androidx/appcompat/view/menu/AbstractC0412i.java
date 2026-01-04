package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: androidx.appcompat.view.menu.i */
/* loaded from: classes.dex */
public abstract class AbstractC0412i implements InterfaceC0417n, InterfaceC0414k, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public Rect f1689a;

    /* renamed from: n */
    public static int m2494n(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i10) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i11 = 0;
        int i12 = 0;
        View view = null;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i13, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    /* renamed from: w */
    public static boolean m2495w(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menuBuilder.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: x */
    public static C0409f m2496x(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0409f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0409f) listAdapter;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: d */
    public boolean mo2415d(MenuBuilder menuBuilder, C0411h c0411h) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: e */
    public boolean mo2416e(MenuBuilder menuBuilder, C0411h c0411h) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: g */
    public void mo2418g(Context context, MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    public int getId() {
        return 0;
    }

    /* renamed from: j */
    public abstract void mo2441j(MenuBuilder menuBuilder);

    /* renamed from: l */
    public boolean mo2443l() {
        return true;
    }

    /* renamed from: m */
    public Rect m2497m() {
        return this.f1689a;
    }

    /* renamed from: o */
    public abstract void mo2444o(View view);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m2496x(listAdapter).f1647a.m2350O((MenuItem) listAdapter.getItem(i10), this, mo2443l() ? 0 : 4);
    }

    /* renamed from: p */
    public void m2498p(Rect rect) {
        this.f1689a = rect;
    }

    /* renamed from: q */
    public abstract void mo2445q(boolean z10);

    /* renamed from: r */
    public abstract void mo2446r(int i10);

    /* renamed from: s */
    public abstract void mo2447s(int i10);

    /* renamed from: t */
    public abstract void mo2448t(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: u */
    public abstract void mo2449u(boolean z10);

    /* renamed from: v */
    public abstract void mo2450v(int i10);
}
