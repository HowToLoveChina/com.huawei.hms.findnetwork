package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.InterfaceC0414k;
import com.huawei.openalliance.p169ad.constant.Constants;
import p273f0.C9603h0;
import p273f0.C9614n;

/* renamed from: androidx.appcompat.view.menu.j */
/* loaded from: classes.dex */
public class C0413j {

    /* renamed from: a */
    public final Context f1690a;

    /* renamed from: b */
    public final MenuBuilder f1691b;

    /* renamed from: c */
    public final boolean f1692c;

    /* renamed from: d */
    public final int f1693d;

    /* renamed from: e */
    public final int f1694e;

    /* renamed from: f */
    public View f1695f;

    /* renamed from: g */
    public int f1696g;

    /* renamed from: h */
    public boolean f1697h;

    /* renamed from: i */
    public InterfaceC0414k.a f1698i;

    /* renamed from: j */
    public AbstractC0412i f1699j;

    /* renamed from: k */
    public PopupWindow.OnDismissListener f1700k;

    /* renamed from: l */
    public final PopupWindow.OnDismissListener f1701l;

    /* renamed from: androidx.appcompat.view.menu.j$a */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            C0413j.this.mo2503e();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$b */
    public static class b {
        /* renamed from: a */
        public static void m2513a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public C0413j(Context context, MenuBuilder menuBuilder, View view, boolean z10, int i10) {
        this(context, menuBuilder, view, z10, i10, 0);
    }

    /* renamed from: a */
    public final AbstractC0412i m2499a() {
        Display defaultDisplay = ((WindowManager) this.f1690a.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay();
        Point point = new Point();
        b.m2513a(defaultDisplay, point);
        AbstractC0412i viewOnKeyListenerC0407d = Math.min(point.x, point.y) >= this.f1690a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new ViewOnKeyListenerC0407d(this.f1690a, this.f1695f, this.f1693d, this.f1694e, this.f1692c) : new ViewOnKeyListenerC0418o(this.f1690a, this.f1691b, this.f1695f, this.f1693d, this.f1694e, this.f1692c);
        viewOnKeyListenerC0407d.mo2441j(this.f1691b);
        viewOnKeyListenerC0407d.mo2448t(this.f1701l);
        viewOnKeyListenerC0407d.mo2444o(this.f1695f);
        viewOnKeyListenerC0407d.mo2417f(this.f1698i);
        viewOnKeyListenerC0407d.mo2445q(this.f1697h);
        viewOnKeyListenerC0407d.mo2446r(this.f1696g);
        return viewOnKeyListenerC0407d;
    }

    /* renamed from: b */
    public void m2500b() {
        if (m2502d()) {
            this.f1699j.dismiss();
        }
    }

    /* renamed from: c */
    public AbstractC0412i m2501c() {
        if (this.f1699j == null) {
            this.f1699j = m2499a();
        }
        return this.f1699j;
    }

    /* renamed from: d */
    public boolean m2502d() {
        AbstractC0412i abstractC0412i = this.f1699j;
        return abstractC0412i != null && abstractC0412i.isShowing();
    }

    /* renamed from: e */
    public void mo2503e() {
        this.f1699j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1700k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: f */
    public void m2504f(View view) {
        this.f1695f = view;
    }

    /* renamed from: g */
    public void m2505g(boolean z10) {
        this.f1697h = z10;
        AbstractC0412i abstractC0412i = this.f1699j;
        if (abstractC0412i != null) {
            abstractC0412i.mo2445q(z10);
        }
    }

    /* renamed from: h */
    public void m2506h(int i10) {
        this.f1696g = i10;
    }

    /* renamed from: i */
    public void m2507i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1700k = onDismissListener;
    }

    /* renamed from: j */
    public void m2508j(InterfaceC0414k.a aVar) {
        this.f1698i = aVar;
        AbstractC0412i abstractC0412i = this.f1699j;
        if (abstractC0412i != null) {
            abstractC0412i.mo2417f(aVar);
        }
    }

    /* renamed from: k */
    public void m2509k() {
        if (!m2511m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: l */
    public final void m2510l(int i10, int i11, boolean z10, boolean z11) {
        AbstractC0412i abstractC0412iM2501c = m2501c();
        abstractC0412iM2501c.mo2449u(z11);
        if (z10) {
            if ((C9614n.m60102b(this.f1696g, C9603h0.m59832A(this.f1695f)) & 7) == 5) {
                i10 -= this.f1695f.getWidth();
            }
            abstractC0412iM2501c.mo2447s(i10);
            abstractC0412iM2501c.mo2450v(i11);
            int i12 = (int) ((this.f1690a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC0412iM2501c.m2498p(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        abstractC0412iM2501c.show();
    }

    /* renamed from: m */
    public boolean m2511m() {
        if (m2502d()) {
            return true;
        }
        if (this.f1695f == null) {
            return false;
        }
        m2510l(0, 0, false, false);
        return true;
    }

    /* renamed from: n */
    public boolean m2512n(int i10, int i11) {
        if (m2502d()) {
            return true;
        }
        if (this.f1695f == null) {
            return false;
        }
        m2510l(i10, i11, true, true);
        return true;
    }

    public C0413j(Context context, MenuBuilder menuBuilder, View view, boolean z10, int i10, int i11) {
        this.f1696g = 8388611;
        this.f1701l = new a();
        this.f1690a = context;
        this.f1691b = menuBuilder;
        this.f1695f = view;
        this.f1692c = z10;
        this.f1693d = i10;
        this.f1694e = i11;
    }
}
