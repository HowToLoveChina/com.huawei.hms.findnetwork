package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.widget.MenuPopupWindow;
import p273f0.C9603h0;

/* renamed from: androidx.appcompat.view.menu.o */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0418o extends AbstractC0412i implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, InterfaceC0414k, View.OnKeyListener {

    /* renamed from: v */
    public static final int f1704v = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b */
    public final Context f1705b;

    /* renamed from: c */
    public final MenuBuilder f1706c;

    /* renamed from: d */
    public final C0409f f1707d;

    /* renamed from: e */
    public final boolean f1708e;

    /* renamed from: f */
    public final int f1709f;

    /* renamed from: g */
    public final int f1710g;

    /* renamed from: h */
    public final int f1711h;

    /* renamed from: i */
    public final MenuPopupWindow f1712i;

    /* renamed from: l */
    public PopupWindow.OnDismissListener f1715l;

    /* renamed from: m */
    public View f1716m;

    /* renamed from: n */
    public View f1717n;

    /* renamed from: o */
    public InterfaceC0414k.a f1718o;

    /* renamed from: p */
    public ViewTreeObserver f1719p;

    /* renamed from: q */
    public boolean f1720q;

    /* renamed from: r */
    public boolean f1721r;

    /* renamed from: s */
    public int f1722s;

    /* renamed from: u */
    public boolean f1724u;

    /* renamed from: j */
    public final ViewTreeObserver.OnGlobalLayoutListener f1713j = new a();

    /* renamed from: k */
    public final View.OnAttachStateChangeListener f1714k = new b();

    /* renamed from: t */
    public int f1723t = 0;

    /* renamed from: androidx.appcompat.view.menu.o$a */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC0418o.this.isShowing() || ViewOnKeyListenerC0418o.this.f1712i.m2738r()) {
                return;
            }
            View view = ViewOnKeyListenerC0418o.this.f1717n;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC0418o.this.dismiss();
            } else {
                ViewOnKeyListenerC0418o.this.f1712i.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.o$b */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = ViewOnKeyListenerC0418o.this.f1719p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    ViewOnKeyListenerC0418o.this.f1719p = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0418o viewOnKeyListenerC0418o = ViewOnKeyListenerC0418o.this;
                viewOnKeyListenerC0418o.f1719p.removeGlobalOnLayoutListener(viewOnKeyListenerC0418o.f1713j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public ViewOnKeyListenerC0418o(Context context, MenuBuilder menuBuilder, View view, int i10, int i11, boolean z10) {
        this.f1705b = context;
        this.f1706c = menuBuilder;
        this.f1708e = z10;
        this.f1707d = new C0409f(menuBuilder, LayoutInflater.from(context), z10, f1704v);
        this.f1710g = i10;
        this.f1711h = i11;
        Resources resources = context.getResources();
        this.f1709f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1716m = view;
        this.f1712i = new MenuPopupWindow(context, null, i10, i11);
        menuBuilder.m2366c(this, context);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: a */
    public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
        if (menuBuilder != this.f1706c) {
            return;
        }
        dismiss();
        InterfaceC0414k.a aVar = this.f1718o;
        if (aVar != null) {
            aVar.mo2158a(menuBuilder, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: b */
    public void mo2414b(boolean z10) {
        this.f1721r = false;
        C0409f c0409f = this.f1707d;
        if (c0409f != null) {
            c0409f.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: c */
    public boolean mo2439c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void dismiss() {
        if (isShowing()) {
            this.f1712i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: f */
    public void mo2417f(InterfaceC0414k.a aVar) {
        this.f1718o = aVar;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public ListView getListView() {
        return this.f1712i.getListView();
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: h */
    public void mo2440h(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: i */
    public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
        if (subMenuC0419p.hasVisibleItems()) {
            C0413j c0413j = new C0413j(this.f1705b, subMenuC0419p, this.f1717n, this.f1708e, this.f1710g, this.f1711h);
            c0413j.m2508j(this.f1718o);
            c0413j.m2505g(AbstractC0412i.m2495w(subMenuC0419p));
            c0413j.m2507i(this.f1715l);
            this.f1715l = null;
            this.f1706c.m2370e(false);
            int horizontalOffset = this.f1712i.getHorizontalOffset();
            int verticalOffset = this.f1712i.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.f1723t, C9603h0.m59832A(this.f1716m)) & 7) == 5) {
                horizontalOffset += this.f1716m.getWidth();
            }
            if (c0413j.m2512n(horizontalOffset, verticalOffset)) {
                InterfaceC0414k.a aVar = this.f1718o;
                if (aVar == null) {
                    return true;
                }
                aVar.mo2159b(subMenuC0419p);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public boolean isShowing() {
        return !this.f1720q && this.f1712i.isShowing();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: j */
    public void mo2441j(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: k */
    public Parcelable mo2442k() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: o */
    public void mo2444o(View view) {
        this.f1716m = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1720q = true;
        this.f1706c.close();
        ViewTreeObserver viewTreeObserver = this.f1719p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1719p = this.f1717n.getViewTreeObserver();
            }
            this.f1719p.removeGlobalOnLayoutListener(this.f1713j);
            this.f1719p = null;
        }
        this.f1717n.removeOnAttachStateChangeListener(this.f1714k);
        PopupWindow.OnDismissListener onDismissListener = this.f1715l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        this.f1707d.m2465d(z10);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: r */
    public void mo2446r(int i10) {
        this.f1723t = i10;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: s */
    public void mo2447s(int i10) {
        this.f1712i.setHorizontalOffset(i10);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void show() {
        if (!m2514y()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: t */
    public void mo2448t(PopupWindow.OnDismissListener onDismissListener) {
        this.f1715l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: u */
    public void mo2449u(boolean z10) {
        this.f1724u = z10;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0412i
    /* renamed from: v */
    public void mo2450v(int i10) {
        this.f1712i.setVerticalOffset(i10);
    }

    /* renamed from: y */
    public final boolean m2514y() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.f1720q || (view = this.f1716m) == null) {
            return false;
        }
        this.f1717n = view;
        this.f1712i.m2720A(this);
        this.f1712i.m2721B(this);
        this.f1712i.m2746z(true);
        View view2 = this.f1717n;
        boolean z10 = this.f1719p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1719p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1713j);
        }
        view2.addOnAttachStateChangeListener(this.f1714k);
        this.f1712i.m2740t(view2);
        this.f1712i.m2743w(this.f1723t);
        if (!this.f1721r) {
            this.f1722s = AbstractC0412i.m2494n(this.f1707d, null, this.f1705b, this.f1709f);
            this.f1721r = true;
        }
        this.f1712i.m2742v(this.f1722s);
        this.f1712i.m2745y(2);
        this.f1712i.m2744x(m2497m());
        this.f1712i.show();
        ListView listView = this.f1712i.getListView();
        listView.setOnKeyListener(this);
        if (this.f1724u && this.f1706c.m2394z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1705b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1706c.m2394z());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.f1712i.setAdapter(this.f1707d);
        this.f1712i.show();
        return true;
    }
}
