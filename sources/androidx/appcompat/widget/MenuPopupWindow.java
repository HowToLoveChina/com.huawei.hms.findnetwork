package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.C0409f;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements InterfaceC0547v {

    /* renamed from: G */
    public InterfaceC0547v f2045G;

    public static class MenuDropDownListView extends DropDownListView {

        /* renamed from: n */
        public final int f2046n;

        /* renamed from: o */
        public final int f2047o;

        /* renamed from: p */
        public InterfaceC0547v f2048p;

        /* renamed from: q */
        public MenuItem f2049q;

        /* renamed from: androidx.appcompat.widget.MenuPopupWindow$MenuDropDownListView$a */
        public static class C0476a {
            /* renamed from: a */
            public static int m2754a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z10) {
            super(context, z10);
            if (1 == C0476a.m2754a(context.getResources().getConfiguration())) {
                this.f2046n = 21;
                this.f2047o = 22;
            } else {
                this.f2046n = 22;
                this.f2047o = 21;
            }
        }

        @Override // androidx.appcompat.widget.DropDownListView
        /* renamed from: d */
        public /* bridge */ /* synthetic */ int mo2682d(int i10, int i11, int i12, int i13, int i14) {
            return super.mo2682d(i10, i11, i12, i13, i14);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        /* renamed from: e */
        public /* bridge */ /* synthetic */ boolean mo2683e(MotionEvent motionEvent, int i10) {
            return super.mo2683e(motionEvent, i10);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            C0409f c0409f;
            int headersCount;
            int iPointToPosition;
            int i10;
            if (this.f2048p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0409f = (C0409f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    c0409f = (C0409f) adapter;
                    headersCount = 0;
                }
                C0411h item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i10 = iPointToPosition - headersCount) < 0 || i10 >= c0409f.getCount()) ? null : c0409f.getItem(i10);
                MenuItem menuItem = this.f2049q;
                if (menuItem != item) {
                    MenuBuilder menuBuilderM2463b = c0409f.m2463b();
                    if (menuItem != null) {
                        this.f2048p.mo2454c(menuBuilderM2463b, menuItem);
                    }
                    this.f2049q = item;
                    if (item != null) {
                        this.f2048p.mo2453a(menuBuilderM2463b, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f2046n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i10 != this.f2047o) {
                return super.onKeyDown(i10, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (C0409f) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (C0409f) adapter).m2463b().m2370e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(InterfaceC0547v interfaceC0547v) {
            this.f2048p = interfaceC0547v;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    /* renamed from: androidx.appcompat.widget.MenuPopupWindow$a */
    public static class C0477a {
        /* renamed from: a */
        public static void m2755a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        /* renamed from: b */
        public static void m2756b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* renamed from: androidx.appcompat.widget.MenuPopupWindow$b */
    public static class C0478b {
        /* renamed from: a */
        public static void m2757a(PopupWindow popupWindow, boolean z10) {
            popupWindow.setTouchModal(z10);
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    /* renamed from: H */
    public void m2750H(Object obj) {
        C0477a.m2755a(this.f2011F, (Transition) obj);
    }

    /* renamed from: I */
    public void m2751I(Object obj) {
        C0477a.m2756b(this.f2011F, (Transition) obj);
    }

    /* renamed from: J */
    public void m2752J(InterfaceC0547v interfaceC0547v) {
        this.f2045G = interfaceC0547v;
    }

    /* renamed from: K */
    public void m2753K(boolean z10) {
        C0478b.m2757a(this.f2011F, z10);
    }

    @Override // androidx.appcompat.widget.InterfaceC0547v
    /* renamed from: a */
    public void mo2453a(MenuBuilder menuBuilder, MenuItem menuItem) {
        InterfaceC0547v interfaceC0547v = this.f2045G;
        if (interfaceC0547v != null) {
            interfaceC0547v.mo2453a(menuBuilder, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0547v
    /* renamed from: c */
    public void mo2454c(MenuBuilder menuBuilder, MenuItem menuItem) {
        InterfaceC0547v interfaceC0547v = this.f2045G;
        if (interfaceC0547v != null) {
            interfaceC0547v.mo2454c(menuBuilder, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    /* renamed from: i */
    public DropDownListView mo2729i(Context context, boolean z10) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z10);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
