package p413k0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.huawei.hms.network.embedded.C5914f2;
import java.util.ArrayList;
import java.util.List;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9822b;
import p304g0.C9832l;
import p304g0.C9833m;
import p304g0.C9834n;
import p413k0.C10969b;
import p438l.C11214h;

/* renamed from: k0.a */
/* loaded from: classes.dex */
public abstract class AbstractC10968a extends C9582a {

    /* renamed from: l */
    public static final Rect f51953l = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: m */
    public static final C10969b.a<C9832l> f51954m = new a();

    /* renamed from: n */
    public static final C10969b.b<C11214h<C9832l>, C9832l> f51955n = new b();

    /* renamed from: f */
    public final AccessibilityManager f51960f;

    /* renamed from: g */
    public final View f51961g;

    /* renamed from: h */
    public c f51962h;

    /* renamed from: b */
    public final Rect f51956b = new Rect();

    /* renamed from: c */
    public final Rect f51957c = new Rect();

    /* renamed from: d */
    public final Rect f51958d = new Rect();

    /* renamed from: e */
    public final int[] f51959e = new int[2];

    /* renamed from: i */
    public int f51963i = Integer.MIN_VALUE;

    /* renamed from: j */
    public int f51964j = Integer.MIN_VALUE;

    /* renamed from: k */
    public int f51965k = Integer.MIN_VALUE;

    /* renamed from: k0.a$a */
    public class a implements C10969b.a<C9832l> {
        @Override // p413k0.C10969b.a
        /* renamed from: b */
        public void mo66229a(C9832l c9832l, Rect rect) {
            c9832l.m61088j(rect);
        }
    }

    /* renamed from: k0.a$b */
    public class b implements C10969b.b<C11214h<C9832l>, C9832l> {
        @Override // p413k0.C10969b.b
        /* renamed from: c */
        public C9832l mo66231a(C11214h<C9832l> c11214h, int i10) {
            return c11214h.m67347o(i10);
        }

        @Override // p413k0.C10969b.b
        /* renamed from: d */
        public int mo66232b(C11214h<C9832l> c11214h) {
            return c11214h.m67346n();
        }
    }

    /* renamed from: k0.a$c */
    public class c extends C9833m {
        public c() {
        }

        @Override // p304g0.C9833m
        /* renamed from: b */
        public C9832l mo61130b(int i10) {
            return C9832l.m61045K(AbstractC10968a.this.m66226w(i10));
        }

        @Override // p304g0.C9833m
        /* renamed from: d */
        public C9832l mo61132d(int i10) {
            int i11 = i10 == 2 ? AbstractC10968a.this.f51963i : AbstractC10968a.this.f51964j;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return mo61130b(i11);
        }

        @Override // p304g0.C9833m
        /* renamed from: f */
        public boolean mo61134f(int i10, int i11, Bundle bundle) {
            return AbstractC10968a.this.m66201E(i10, i11, bundle);
        }
    }

    public AbstractC10968a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f51961g = view;
        this.f51960f = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (C9603h0.m59919y(view) == 0) {
            C9603h0.m59833A0(view, 1);
        }
    }

    /* renamed from: q */
    public static Rect m66198q(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
        } else if (i10 == 33) {
            rect.set(0, height, width, height);
        } else if (i10 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    /* renamed from: u */
    public static int m66199u(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 != 21) {
            return i10 != 22 ? 130 : 66;
        }
        return 17;
    }

    /* renamed from: A */
    public void m66200A(int i10, AccessibilityEvent accessibilityEvent) {
    }

    /* renamed from: B */
    public void mo10022B(C9832l c9832l) {
    }

    /* renamed from: C */
    public abstract void mo10023C(int i10, C9832l c9832l);

    /* renamed from: D */
    public void mo10024D(int i10, boolean z10) {
    }

    /* renamed from: E */
    public boolean m66201E(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? m66202F(i10, i11, bundle) : m66203G(i11, bundle);
    }

    /* renamed from: F */
    public final boolean m66202F(int i10, int i11, Bundle bundle) {
        return i11 != 1 ? i11 != 2 ? i11 != 64 ? i11 != 128 ? mo10027y(i10, i11, bundle) : m66208a(i10) : m66204H(i10) : m66209b(i10) : m66205I(i10);
    }

    /* renamed from: G */
    public final boolean m66203G(int i10, Bundle bundle) {
        return C9603h0.m59880e0(this.f51961g, i10, bundle);
    }

    /* renamed from: H */
    public final boolean m66204H(int i10) {
        int i11;
        if (!this.f51960f.isEnabled() || !this.f51960f.isTouchExplorationEnabled() || (i11 = this.f51963i) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            m66208a(i11);
        }
        this.f51963i = i10;
        this.f51961g.invalidate();
        m66206J(i10, C5914f2.f26733f);
        return true;
    }

    /* renamed from: I */
    public final boolean m66205I(int i10) {
        int i11;
        if ((!this.f51961g.isFocused() && !this.f51961g.requestFocus()) || (i11 = this.f51964j) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            m66209b(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f51964j = i10;
        mo10024D(i10, true);
        m66206J(i10, 8);
        return true;
    }

    /* renamed from: J */
    public final boolean m66206J(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f51960f.isEnabled() || (parent = this.f51961g.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f51961g, m66211d(i10, i11));
    }

    /* renamed from: K */
    public final void m66207K(int i10) {
        int i11 = this.f51965k;
        if (i11 == i10) {
            return;
        }
        this.f51965k = i10;
        m66206J(i10, 128);
        m66206J(i11, 256);
    }

    /* renamed from: a */
    public final boolean m66208a(int i10) {
        if (this.f51963i != i10) {
            return false;
        }
        this.f51963i = Integer.MIN_VALUE;
        this.f51961g.invalidate();
        m66206J(i10, 65536);
        return true;
    }

    /* renamed from: b */
    public final boolean m66209b(int i10) {
        if (this.f51964j != i10) {
            return false;
        }
        this.f51964j = Integer.MIN_VALUE;
        mo10024D(i10, false);
        m66206J(i10, 8);
        return true;
    }

    /* renamed from: c */
    public final boolean m66210c() {
        int i10 = this.f51964j;
        return i10 != Integer.MIN_VALUE && mo10027y(i10, 16, null);
    }

    /* renamed from: d */
    public final AccessibilityEvent m66211d(int i10, int i11) {
        return i10 != -1 ? m66212e(i10, i11) : m66213f(i11);
    }

    /* renamed from: e */
    public final AccessibilityEvent m66212e(int i10, int i11) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
        C9832l c9832lM66226w = m66226w(i10);
        accessibilityEventObtain.getText().add(c9832lM66226w.m61103r());
        accessibilityEventObtain.setContentDescription(c9832lM66226w.m61097o());
        accessibilityEventObtain.setScrollable(c9832lM66226w.m61052E());
        accessibilityEventObtain.setPassword(c9832lM66226w.m61051D());
        accessibilityEventObtain.setEnabled(c9832lM66226w.m61119z());
        accessibilityEventObtain.setChecked(c9832lM66226w.m61115x());
        m66200A(i10, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(c9832lM66226w.m61094m());
        C9834n.m61137c(accessibilityEventObtain, this.f51961g, i10);
        accessibilityEventObtain.setPackageName(this.f51961g.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    /* renamed from: f */
    public final AccessibilityEvent m66213f(int i10) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        this.f51961g.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    /* renamed from: g */
    public final C9832l m66214g(int i10) {
        C9832l c9832lM61043I = C9832l.m61043I();
        c9832lM61043I.m61074b0(true);
        c9832lM61043I.m61078d0(true);
        c9832lM61043I.m61065U("android.view.View");
        Rect rect = f51953l;
        c9832lM61043I.m61060P(rect);
        c9832lM61043I.m61061Q(rect);
        c9832lM61043I.m61093l0(this.f51961g);
        mo10023C(i10, c9832lM61043I);
        if (c9832lM61043I.m61103r() == null && c9832lM61043I.m61097o() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        c9832lM61043I.m61088j(this.f51957c);
        if (this.f51957c.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iM61086i = c9832lM61043I.m61086i();
        if ((iM61086i & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iM61086i & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        c9832lM61043I.m61089j0(this.f51961g.getContext().getPackageName());
        c9832lM61043I.m61110u0(this.f51961g, i10);
        if (this.f51963i == i10) {
            c9832lM61043I.m61059O(true);
            c9832lM61043I.m61071a(128);
        } else {
            c9832lM61043I.m61059O(false);
            c9832lM61043I.m61071a(64);
        }
        boolean z10 = this.f51964j == i10;
        if (z10) {
            c9832lM61043I.m61071a(2);
        } else if (c9832lM61043I.m61048A()) {
            c9832lM61043I.m61071a(1);
        }
        c9832lM61043I.m61080e0(z10);
        this.f51961g.getLocationOnScreen(this.f51959e);
        c9832lM61043I.m61090k(this.f51956b);
        if (this.f51956b.equals(rect)) {
            c9832lM61043I.m61088j(this.f51956b);
            if (c9832lM61043I.f48272b != -1) {
                C9832l c9832lM61043I2 = C9832l.m61043I();
                for (int i11 = c9832lM61043I.f48272b; i11 != -1; i11 = c9832lM61043I2.f48272b) {
                    c9832lM61043I2.m61095m0(this.f51961g, -1);
                    c9832lM61043I2.m61060P(f51953l);
                    mo10023C(i11, c9832lM61043I2);
                    c9832lM61043I2.m61088j(this.f51957c);
                    Rect rect2 = this.f51956b;
                    Rect rect3 = this.f51957c;
                    rect2.offset(rect3.left, rect3.top);
                }
                c9832lM61043I2.m61057M();
            }
            this.f51956b.offset(this.f51959e[0] - this.f51961g.getScrollX(), this.f51959e[1] - this.f51961g.getScrollY());
        }
        if (this.f51961g.getLocalVisibleRect(this.f51958d)) {
            this.f51958d.offset(this.f51959e[0] - this.f51961g.getScrollX(), this.f51959e[1] - this.f51961g.getScrollY());
            if (this.f51956b.intersect(this.f51958d)) {
                c9832lM61043I.m61061Q(this.f51956b);
                if (m66224t(this.f51956b)) {
                    c9832lM61043I.m61118y0(true);
                }
            }
        }
        return c9832lM61043I;
    }

    @Override // p273f0.C9582a
    public C9833m getAccessibilityNodeProvider(View view) {
        if (this.f51962h == null) {
            this.f51962h = new c();
        }
        return this.f51962h;
    }

    /* renamed from: h */
    public final C9832l m66215h() {
        C9832l c9832lM61044J = C9832l.m61044J(this.f51961g);
        C9603h0.m59876c0(this.f51961g, c9832lM61044J);
        ArrayList arrayList = new ArrayList();
        mo10026p(arrayList);
        if (c9832lM61044J.m61092l() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            c9832lM61044J.m61077d(this.f51961g, ((Integer) arrayList.get(i10)).intValue());
        }
        return c9832lM61044J;
    }

    /* renamed from: i */
    public final boolean m66216i(MotionEvent motionEvent) {
        if (!this.f51960f.isEnabled() || !this.f51960f.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iMo10025o = mo10025o(motionEvent.getX(), motionEvent.getY());
            m66207K(iMo10025o);
            return iMo10025o != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f51965k == Integer.MIN_VALUE) {
            return false;
        }
        m66207K(Integer.MIN_VALUE);
        return true;
    }

    /* renamed from: j */
    public final boolean m66217j(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return m66225v(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return m66225v(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iM66199u = m66199u(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z10 = false;
                    while (i10 < repeatCount && m66225v(iM66199u, null)) {
                        i10++;
                        z10 = true;
                    }
                    return z10;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        m66210c();
        return true;
    }

    /* renamed from: k */
    public final int m66218k() {
        return this.f51963i;
    }

    /* renamed from: l */
    public final C11214h<C9832l> m66219l() {
        ArrayList arrayList = new ArrayList();
        mo10026p(arrayList);
        C11214h<C9832l> c11214h = new C11214h<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            c11214h.m67344l(arrayList.get(i10).intValue(), m66214g(arrayList.get(i10).intValue()));
        }
        return c11214h;
    }

    /* renamed from: m */
    public final void m66220m(int i10, Rect rect) {
        m66226w(i10).m61088j(rect);
    }

    /* renamed from: n */
    public final int m66221n() {
        return this.f51964j;
    }

    /* renamed from: o */
    public abstract int mo10025o(float f10, float f11);

    @Override // p273f0.C9582a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        m66228z(accessibilityEvent);
    }

    @Override // p273f0.C9582a
    public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
        super.onInitializeAccessibilityNodeInfo(view, c9832l);
        mo10022B(c9832l);
    }

    /* renamed from: p */
    public abstract void mo10026p(List<Integer> list);

    /* renamed from: r */
    public final void m66222r(int i10) {
        m66223s(i10, 0);
    }

    /* renamed from: s */
    public final void m66223s(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f51960f.isEnabled() || (parent = this.f51961g.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventM66211d = m66211d(i10, 2048);
        C9822b.m61027b(accessibilityEventM66211d, i11);
        parent.requestSendAccessibilityEvent(this.f51961g, accessibilityEventM66211d);
    }

    /* renamed from: t */
    public final boolean m66224t(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f51961g.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f51961g.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    /* renamed from: v */
    public final boolean m66225v(int i10, Rect rect) {
        C9832l c9832l;
        C11214h<C9832l> c11214hM66219l = m66219l();
        int i11 = this.f51964j;
        C9832l c9832lM67340g = i11 == Integer.MIN_VALUE ? null : c11214hM66219l.m67340g(i11);
        if (i10 == 1 || i10 == 2) {
            c9832l = (C9832l) C10969b.m66238d(c11214hM66219l, f51955n, f51954m, c9832lM67340g, i10, C9603h0.m59832A(this.f51961g) == 1, false);
        } else {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i12 = this.f51964j;
            if (i12 != Integer.MIN_VALUE) {
                m66220m(i12, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                m66198q(this.f51961g, i10, rect2);
            }
            c9832l = (C9832l) C10969b.m66237c(c11214hM66219l, f51955n, f51954m, c9832lM67340g, rect2, i10);
        }
        return m66205I(c9832l != null ? c11214hM66219l.m67343k(c11214hM66219l.m67342j(c9832l)) : Integer.MIN_VALUE);
    }

    /* renamed from: w */
    public C9832l m66226w(int i10) {
        return i10 == -1 ? m66215h() : m66214g(i10);
    }

    /* renamed from: x */
    public final void m66227x(boolean z10, int i10, Rect rect) {
        int i11 = this.f51964j;
        if (i11 != Integer.MIN_VALUE) {
            m66209b(i11);
        }
        if (z10) {
            m66225v(i10, rect);
        }
    }

    /* renamed from: y */
    public abstract boolean mo10027y(int i10, int i11, Bundle bundle);

    /* renamed from: z */
    public void m66228z(AccessibilityEvent accessibilityEvent) {
    }
}
