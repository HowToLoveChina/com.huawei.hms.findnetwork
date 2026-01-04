package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.widget.InterfaceC0547v;
import androidx.appcompat.widget.MenuPopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;
import p273f0.C9614n;

/* renamed from: androidx.appcompat.view.menu.d */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0407d extends AbstractC0412i implements InterfaceC0414k, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B */
    public static final int f1598B = R$layout.abc_cascading_menu_item_layout;

    /* renamed from: A */
    public boolean f1599A;

    /* renamed from: b */
    public final Context f1600b;

    /* renamed from: c */
    public final int f1601c;

    /* renamed from: d */
    public final int f1602d;

    /* renamed from: e */
    public final int f1603e;

    /* renamed from: f */
    public final boolean f1604f;

    /* renamed from: g */
    public final Handler f1605g;

    /* renamed from: o */
    public View f1613o;

    /* renamed from: p */
    public View f1614p;

    /* renamed from: r */
    public boolean f1616r;

    /* renamed from: s */
    public boolean f1617s;

    /* renamed from: t */
    public int f1618t;

    /* renamed from: u */
    public int f1619u;

    /* renamed from: w */
    public boolean f1621w;

    /* renamed from: x */
    public InterfaceC0414k.a f1622x;

    /* renamed from: y */
    public ViewTreeObserver f1623y;

    /* renamed from: z */
    public PopupWindow.OnDismissListener f1624z;

    /* renamed from: h */
    public final List<MenuBuilder> f1606h = new ArrayList();

    /* renamed from: i */
    public final List<d> f1607i = new ArrayList();

    /* renamed from: j */
    public final ViewTreeObserver.OnGlobalLayoutListener f1608j = new a();

    /* renamed from: k */
    public final View.OnAttachStateChangeListener f1609k = new b();

    /* renamed from: l */
    public final InterfaceC0547v f1610l = new c();

    /* renamed from: m */
    public int f1611m = 0;

    /* renamed from: n */
    public int f1612n = 0;

    /* renamed from: v */
    public boolean f1620v = false;

    /* renamed from: q */
    public int f1615q = m2436C();

    /* renamed from: androidx.appcompat.view.menu.d$a */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC0407d.this.isShowing() || ViewOnKeyListenerC0407d.this.f1607i.size() <= 0 || ViewOnKeyListenerC0407d.this.f1607i.get(0).f1632a.m2738r()) {
                return;
            }
            View view = ViewOnKeyListenerC0407d.this.f1614p;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC0407d.this.dismiss();
                return;
            }
            Iterator<d> it = ViewOnKeyListenerC0407d.this.f1607i.iterator();
            while (it.hasNext()) {
                it.next().f1632a.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$b */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = ViewOnKeyListenerC0407d.this.f1623y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    ViewOnKeyListenerC0407d.this.f1623y = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0407d viewOnKeyListenerC0407d = ViewOnKeyListenerC0407d.this;
                viewOnKeyListenerC0407d.f1623y.removeGlobalOnLayoutListener(viewOnKeyListenerC0407d.f1608j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$c */
    public class c implements InterfaceC0547v {

        /* renamed from: androidx.appcompat.view.menu.d$c$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ d f1628a;

            /* renamed from: b */
            public final /* synthetic */ MenuItem f1629b;

            /* renamed from: c */
            public final /* synthetic */ MenuBuilder f1630c;

            public a(d dVar, MenuItem menuItem, MenuBuilder menuBuilder) {
                this.f1628a = dVar;
                this.f1629b = menuItem;
                this.f1630c = menuBuilder;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f1628a;
                if (dVar != null) {
                    ViewOnKeyListenerC0407d.this.f1599A = true;
                    dVar.f1633b.m2370e(false);
                    ViewOnKeyListenerC0407d.this.f1599A = false;
                }
                if (this.f1629b.isEnabled() && this.f1629b.hasSubMenu()) {
                    this.f1630c.m2349N(this.f1629b, 4);
                }
            }
        }

        public c() {
        }

        @Override // androidx.appcompat.widget.InterfaceC0547v
        /* renamed from: a */
        public void mo2453a(MenuBuilder menuBuilder, MenuItem menuItem) {
            ViewOnKeyListenerC0407d.this.f1605g.removeCallbacksAndMessages(null);
            int size = ViewOnKeyListenerC0407d.this.f1607i.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (menuBuilder == ViewOnKeyListenerC0407d.this.f1607i.get(i10).f1633b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            ViewOnKeyListenerC0407d.this.f1605g.postAtTime(new a(i11 < ViewOnKeyListenerC0407d.this.f1607i.size() ? ViewOnKeyListenerC0407d.this.f1607i.get(i11) : null, menuItem, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.InterfaceC0547v
        /* renamed from: c */
        public void mo2454c(MenuBuilder menuBuilder, MenuItem menuItem) {
            ViewOnKeyListenerC0407d.this.f1605g.removeCallbacksAndMessages(menuBuilder);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$d */
    public static class d {

        /* renamed from: a */
        public final MenuPopupWindow f1632a;

        /* renamed from: b */
        public final MenuBuilder f1633b;

        /* renamed from: c */
        public final int f1634c;

        public d(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i10) {
            this.f1632a = menuPopupWindow;
            this.f1633b = menuBuilder;
            this.f1634c = i10;
        }

        /* renamed from: a */
        public ListView m2455a() {
            return this.f1632a.getListView();
        }
    }

    public ViewOnKeyListenerC0407d(Context context, View view, int i10, int i11, boolean z10) {
        this.f1600b = context;
        this.f1613o = view;
        this.f1602d = i10;
        this.f1603e = i11;
        this.f1604f = z10;
        Resources resources = context.getResources();
        this.f1601c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1605g = new Handler();
    }

    /* renamed from: A */
    public final MenuItem m2434A(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menuBuilder.getItem(i10);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: B */
    public final View m2435B(d dVar, MenuBuilder menuBuilder) {
        C0409f c0409f;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemM2434A = m2434A(dVar.f1633b, menuBuilder);
        if (menuItemM2434A == null) {
            return null;
        }
        ListView listViewM2455a = dVar.m2455a();
        ListAdapter adapter = listViewM2455a.getAdapter();
        int i10 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0409f = (C0409f) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0409f = (C0409f) adapter;
            headersCount = 0;
        }
        int count = c0409f.getCount();
        while (true) {
            if (i10 >= count) {
                i10 = -1;
                break;
            }
            if (menuItemM2434A == c0409f.getItem(i10)) {
                break;
            }
            i10++;
        }
        if (i10 != -1 && (firstVisiblePosition = (i10 + headersCount) - listViewM2455a.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewM2455a.getChildCount()) {
            return listViewM2455a.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    /* renamed from: C */
    public final int m2436C() {
        return C9603h0.m59832A(this.f1613o) == 1 ? 0 : 1;
    }

    /* renamed from: D */
    public final int m2437D(int i10) {
        List<d> list = this.f1607i;
        ListView listViewM2455a = list.get(list.size() - 1).m2455a();
        int[] iArr = new int[2];
        listViewM2455a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1614p.getWindowVisibleDisplayFrame(rect);
        return this.f1615q == 1 ? (iArr[0] + listViewM2455a.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    /* renamed from: E */
    public final void m2438E(MenuBuilder menuBuilder) {
        d dVar;
        View viewM2435B;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1600b);
        C0409f c0409f = new C0409f(menuBuilder, layoutInflaterFrom, this.f1604f, f1598B);
        if (!isShowing() && this.f1620v) {
            c0409f.m2465d(true);
        } else if (isShowing()) {
            c0409f.m2465d(AbstractC0412i.m2495w(menuBuilder));
        }
        int iM2494n = AbstractC0412i.m2494n(c0409f, null, this.f1600b, this.f1601c);
        MenuPopupWindow menuPopupWindowM2451y = m2451y();
        menuPopupWindowM2451y.setAdapter(c0409f);
        menuPopupWindowM2451y.m2742v(iM2494n);
        menuPopupWindowM2451y.m2743w(this.f1612n);
        if (this.f1607i.size() > 0) {
            List<d> list = this.f1607i;
            dVar = list.get(list.size() - 1);
            viewM2435B = m2435B(dVar, menuBuilder);
        } else {
            dVar = null;
            viewM2435B = null;
        }
        if (viewM2435B != null) {
            menuPopupWindowM2451y.m2753K(false);
            menuPopupWindowM2451y.m2750H(null);
            int iM2437D = m2437D(iM2494n);
            boolean z10 = iM2437D == 1;
            this.f1615q = iM2437D;
            menuPopupWindowM2451y.m2740t(viewM2435B);
            if ((this.f1612n & 5) != 5) {
                iM2494n = z10 ? viewM2435B.getWidth() : 0 - iM2494n;
            } else if (!z10) {
                iM2494n = 0 - viewM2435B.getWidth();
            }
            menuPopupWindowM2451y.setHorizontalOffset(iM2494n);
            menuPopupWindowM2451y.m2722C(true);
            menuPopupWindowM2451y.setVerticalOffset(0);
        } else {
            if (this.f1616r) {
                menuPopupWindowM2451y.setHorizontalOffset(this.f1618t);
            }
            if (this.f1617s) {
                menuPopupWindowM2451y.setVerticalOffset(this.f1619u);
            }
            menuPopupWindowM2451y.m2744x(m2497m());
        }
        this.f1607i.add(new d(menuPopupWindowM2451y, menuBuilder, this.f1615q));
        menuPopupWindowM2451y.show();
        ListView listView = menuPopupWindowM2451y.getListView();
        listView.setOnKeyListener(this);
        if (dVar == null && this.f1621w && menuBuilder.m2394z() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.m2394z());
            listView.addHeaderView(frameLayout, null, false);
            menuPopupWindowM2451y.show();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: a */
    public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
        int iM2452z = m2452z(menuBuilder);
        if (iM2452z < 0) {
            return;
        }
        int i10 = iM2452z + 1;
        if (i10 < this.f1607i.size()) {
            this.f1607i.get(i10).f1633b.m2370e(false);
        }
        d dVarRemove = this.f1607i.remove(iM2452z);
        dVarRemove.f1633b.m2352Q(this);
        if (this.f1599A) {
            dVarRemove.f1632a.m2751I(null);
            dVarRemove.f1632a.m2741u(0);
        }
        dVarRemove.f1632a.dismiss();
        int size = this.f1607i.size();
        if (size > 0) {
            this.f1615q = this.f1607i.get(size - 1).f1634c;
        } else {
            this.f1615q = m2436C();
        }
        if (size != 0) {
            if (z10) {
                this.f1607i.get(0).f1633b.m2370e(false);
                return;
            }
            return;
        }
        dismiss();
        InterfaceC0414k.a aVar = this.f1622x;
        if (aVar != null) {
            aVar.mo2158a(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1623y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1623y.removeGlobalOnLayoutListener(this.f1608j);
            }
            this.f1623y = null;
        }
        this.f1614p.removeOnAttachStateChangeListener(this.f1609k);
        this.f1624z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: b */
    public void mo2414b(boolean z10) {
        Iterator<d> it = this.f1607i.iterator();
        while (it.hasNext()) {
            AbstractC0412i.m2496x(it.next().m2455a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: c */
    public boolean mo2439c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void dismiss() {
        int size = this.f1607i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f1607i.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f1632a.isShowing()) {
                    dVar.f1632a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: f */
    public void mo2417f(InterfaceC0414k.a aVar) {
        this.f1622x = aVar;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public ListView getListView() {
        if (this.f1607i.isEmpty()) {
            return null;
        }
        return this.f1607i.get(r1.size() - 1).m2455a();
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: h */
    public void mo2440h(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: i */
    public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
        for (d dVar : this.f1607i) {
            if (subMenuC0419p == dVar.f1633b) {
                dVar.m2455a().requestFocus();
                return true;
            }
        }
        if (!subMenuC0419p.hasVisibleItems()) {
            return false;
        }
        mo2441j(subMenuC0419p);
        InterfaceC0414k.a aVar = this.f1622x;
        if (aVar != null) {
            aVar.mo2159b(subMenuC0419p);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public boolean isShowing() {
        return this.f1607i.size() > 0 && this.f1607i.get(0).f1632a.isShowing();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: j */
    public void mo2441j(MenuBuilder menuBuilder) {
        menuBuilder.m2366c(this, this.f1600b);
        if (isShowing()) {
            m2438E(menuBuilder);
        } else {
            this.f1606h.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: k */
    public Parcelable mo2442k() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: l */
    public boolean mo2443l() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: o */
    public void mo2444o(View view) {
        if (this.f1613o != view) {
            this.f1613o = view;
            this.f1612n = C9614n.m60102b(this.f1611m, C9603h0.m59832A(view));
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f1607i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f1607i.get(i10);
            if (!dVar.f1632a.isShowing()) {
                break;
            } else {
                i10++;
            }
        }
        if (dVar != null) {
            dVar.f1633b.m2370e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: q */
    public void mo2445q(boolean z10) {
        this.f1620v = z10;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: r */
    public void mo2446r(int i10) {
        if (this.f1611m != i10) {
            this.f1611m = i10;
            this.f1612n = C9614n.m60102b(i10, C9603h0.m59832A(this.f1613o));
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: s */
    public void mo2447s(int i10) {
        this.f1616r = true;
        this.f1618t = i10;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void show() {
        if (isShowing()) {
            return;
        }
        Iterator<MenuBuilder> it = this.f1606h.iterator();
        while (it.hasNext()) {
            m2438E(it.next());
        }
        this.f1606h.clear();
        View view = this.f1613o;
        this.f1614p = view;
        if (view != null) {
            boolean z10 = this.f1623y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1623y = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1608j);
            }
            this.f1614p.addOnAttachStateChangeListener(this.f1609k);
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: t */
    public void mo2448t(PopupWindow.OnDismissListener onDismissListener) {
        this.f1624z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: u */
    public void mo2449u(boolean z10) {
        this.f1621w = z10;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: v */
    public void mo2450v(int i10) {
        this.f1617s = true;
        this.f1619u = i10;
    }

    /* renamed from: y */
    public final MenuPopupWindow m2451y() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f1600b, null, this.f1602d, this.f1603e);
        menuPopupWindow.m2752J(this.f1610l);
        menuPopupWindow.m2721B(this);
        menuPopupWindow.m2720A(this);
        menuPopupWindow.m2740t(this.f1613o);
        menuPopupWindow.m2743w(this.f1612n);
        menuPopupWindow.m2746z(true);
        menuPopupWindow.m2745y(2);
        return menuPopupWindow;
    }

    /* renamed from: z */
    public final int m2452z(MenuBuilder menuBuilder) {
        int size = this.f1607i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (menuBuilder == this.f1607i.get(i10).f1633b) {
                return i10;
            }
        }
        return -1;
    }
}
