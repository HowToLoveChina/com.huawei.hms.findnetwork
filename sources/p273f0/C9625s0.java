package p273f0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import p243e0.C9368c;
import p243e0.C9373h;
import p723w.C13504c;

/* renamed from: f0.s0 */
/* loaded from: classes.dex */
public class C9625s0 {

    /* renamed from: b */
    public static final C9625s0 f47738b;

    /* renamed from: a */
    public final k f47739a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    /* renamed from: f0.s0$a */
    public static class a {

        /* renamed from: a */
        public static Field f47740a;

        /* renamed from: b */
        public static Field f47741b;

        /* renamed from: c */
        public static Field f47742c;

        /* renamed from: d */
        public static boolean f47743d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f47740a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f47741b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f47742c = declaredField3;
                declaredField3.setAccessible(true);
                f47743d = true;
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        /* renamed from: a */
        public static C9625s0 m60169a(View view) throws IllegalAccessException, IllegalArgumentException {
            if (f47743d && view.isAttachedToWindow()) {
                try {
                    Object obj = f47740a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f47741b.get(obj);
                        Rect rect2 = (Rect) f47742c.get(obj);
                        if (rect != null && rect2 != null) {
                            C9625s0 c9625s0M60170a = new b().m60171b(C13504c.m81229c(rect)).m60172c(C13504c.m81229c(rect2)).m60170a();
                            c9625s0M60170a.m60167t(c9625s0M60170a);
                            c9625s0M60170a.m60152d(view.getRootView());
                            return c9625s0M60170a;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    /* renamed from: f0.s0$d */
    public static class d extends c {
        public d() {
        }

        public d(C9625s0 c9625s0) {
            super(c9625s0);
        }
    }

    /* renamed from: f0.s0$e */
    public static class e {

        /* renamed from: a */
        public final C9625s0 f47746a;

        /* renamed from: b */
        public C13504c[] f47747b;

        public e() {
            this(new C9625s0((C9625s0) null));
        }

        /* renamed from: a */
        public final void m60179a() {
            C13504c[] c13504cArr = this.f47747b;
            if (c13504cArr != null) {
                C13504c c13504cM60154f = c13504cArr[l.m60203a(1)];
                C13504c c13504cM60154f2 = this.f47747b[l.m60203a(2)];
                if (c13504cM60154f2 == null) {
                    c13504cM60154f2 = this.f47746a.m60154f(2);
                }
                if (c13504cM60154f == null) {
                    c13504cM60154f = this.f47746a.m60154f(1);
                }
                mo60177f(C13504c.m81227a(c13504cM60154f, c13504cM60154f2));
                C13504c c13504c = this.f47747b[l.m60203a(16)];
                if (c13504c != null) {
                    mo60176e(c13504c);
                }
                C13504c c13504c2 = this.f47747b[l.m60203a(32)];
                if (c13504c2 != null) {
                    mo60174c(c13504c2);
                }
                C13504c c13504c3 = this.f47747b[l.m60203a(64)];
                if (c13504c3 != null) {
                    mo60178g(c13504c3);
                }
            }
        }

        /* renamed from: b */
        public C9625s0 mo60173b() {
            throw null;
        }

        /* renamed from: c */
        public void mo60174c(C13504c c13504c) {
            throw null;
        }

        /* renamed from: d */
        public void mo60175d(C13504c c13504c) {
            throw null;
        }

        /* renamed from: e */
        public void mo60176e(C13504c c13504c) {
            throw null;
        }

        /* renamed from: f */
        public void mo60177f(C13504c c13504c) {
            throw null;
        }

        /* renamed from: g */
        public void mo60178g(C13504c c13504c) {
            throw null;
        }

        public e(C9625s0 c9625s0) {
            this.f47746a = c9625s0;
        }
    }

    /* renamed from: f0.s0$h */
    public static class h extends g {
        public h(C9625s0 c9625s0, WindowInsets windowInsets) {
            super(c9625s0, windowInsets);
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: a */
        public C9625s0 mo60198a() {
            return C9625s0.m60147v(this.f47753c.consumeDisplayCutout());
        }

        @Override // p273f0.C9625s0.f, p273f0.C9625s0.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.f47753c, hVar.f47753c) && Objects.equals(this.f47757g, hVar.f47757g);
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: f */
        public C9610l mo60199f() {
            return C9610l.m60074e(this.f47753c.getDisplayCutout());
        }

        @Override // p273f0.C9625s0.k
        public int hashCode() {
            return this.f47753c.hashCode();
        }

        public h(C9625s0 c9625s0, h hVar) {
            super(c9625s0, hVar);
        }
    }

    /* renamed from: f0.s0$j */
    public static class j extends i {

        /* renamed from: q */
        public static final C9625s0 f47762q = C9625s0.m60147v(WindowInsets.CONSUMED);

        public j(C9625s0 c9625s0, WindowInsets windowInsets) {
            super(c9625s0, windowInsets);
        }

        @Override // p273f0.C9625s0.f, p273f0.C9625s0.k
        /* renamed from: d */
        public final void mo60184d(View view) {
        }

        @Override // p273f0.C9625s0.f, p273f0.C9625s0.k
        /* renamed from: g */
        public C13504c mo60186g(int i10) {
            return C13504c.m81230d(this.f47753c.getInsets(m.m60206a(i10)));
        }

        public j(C9625s0 c9625s0, j jVar) {
            super(c9625s0, jVar);
        }
    }

    /* renamed from: f0.s0$k */
    public static class k {

        /* renamed from: b */
        public static final C9625s0 f47763b = new b().m60170a().m60149a().m60150b().m60151c();

        /* renamed from: a */
        public final C9625s0 f47764a;

        public k(C9625s0 c9625s0) {
            this.f47764a = c9625s0;
        }

        /* renamed from: a */
        public C9625s0 mo60198a() {
            return this.f47764a;
        }

        /* renamed from: b */
        public C9625s0 mo60194b() {
            return this.f47764a;
        }

        /* renamed from: c */
        public C9625s0 mo60195c() {
            return this.f47764a;
        }

        /* renamed from: d */
        public void mo60184d(View view) {
        }

        /* renamed from: e */
        public void mo60185e(C9625s0 c9625s0) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return mo60189o() == kVar.mo60189o() && mo60197n() == kVar.mo60197n() && C9368c.m58729a(mo60187k(), kVar.mo60187k()) && C9368c.m58729a(mo60196i(), kVar.mo60196i()) && C9368c.m58729a(mo60199f(), kVar.mo60199f());
        }

        /* renamed from: f */
        public C9610l mo60199f() {
            return null;
        }

        /* renamed from: g */
        public C13504c mo60186g(int i10) {
            return C13504c.f60769e;
        }

        /* renamed from: h */
        public C13504c mo60200h() {
            return mo60187k();
        }

        public int hashCode() {
            return C9368c.m58730b(Boolean.valueOf(mo60189o()), Boolean.valueOf(mo60197n()), mo60187k(), mo60196i(), mo60199f());
        }

        /* renamed from: i */
        public C13504c mo60196i() {
            return C13504c.f60769e;
        }

        /* renamed from: j */
        public C13504c mo60201j() {
            return mo60187k();
        }

        /* renamed from: k */
        public C13504c mo60187k() {
            return C13504c.f60769e;
        }

        /* renamed from: l */
        public C13504c mo60202l() {
            return mo60187k();
        }

        /* renamed from: m */
        public C9625s0 mo60188m(int i10, int i11, int i12, int i13) {
            return f47763b;
        }

        /* renamed from: n */
        public boolean mo60197n() {
            return false;
        }

        /* renamed from: o */
        public boolean mo60189o() {
            return false;
        }

        /* renamed from: p */
        public void mo60190p(C13504c[] c13504cArr) {
        }

        /* renamed from: q */
        public void mo60191q(C13504c c13504c) {
        }

        /* renamed from: r */
        public void mo60192r(C9625s0 c9625s0) {
        }
    }

    /* renamed from: f0.s0$l */
    public static final class l {
        /* renamed from: a */
        public static int m60203a(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        /* renamed from: b */
        public static int m60204b() {
            return 32;
        }

        /* renamed from: c */
        public static int m60205c() {
            return 7;
        }
    }

    /* renamed from: f0.s0$m */
    public static final class m {
        /* renamed from: a */
        public static int m60206a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f47738b = j.f47762q;
        } else {
            f47738b = k.f47763b;
        }
    }

    public C9625s0(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f47739a = new j(this, windowInsets);
        } else {
            this.f47739a = new i(this, windowInsets);
        }
    }

    /* renamed from: o */
    public static C13504c m60146o(C13504c c13504c, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, c13504c.f60770a - i10);
        int iMax2 = Math.max(0, c13504c.f60771b - i11);
        int iMax3 = Math.max(0, c13504c.f60772c - i12);
        int iMax4 = Math.max(0, c13504c.f60773d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? c13504c : C13504c.m81228b(iMax, iMax2, iMax3, iMax4);
    }

    /* renamed from: v */
    public static C9625s0 m60147v(WindowInsets windowInsets) {
        return m60148w(windowInsets, null);
    }

    /* renamed from: w */
    public static C9625s0 m60148w(WindowInsets windowInsets, View view) {
        C9625s0 c9625s0 = new C9625s0((WindowInsets) C9373h.m58745f(windowInsets));
        if (view != null && C9603h0.m59863S(view)) {
            c9625s0.m60167t(C9603h0.m59846H(view));
            c9625s0.m60152d(view.getRootView());
        }
        return c9625s0;
    }

    @Deprecated
    /* renamed from: a */
    public C9625s0 m60149a() {
        return this.f47739a.mo60198a();
    }

    @Deprecated
    /* renamed from: b */
    public C9625s0 m60150b() {
        return this.f47739a.mo60194b();
    }

    @Deprecated
    /* renamed from: c */
    public C9625s0 m60151c() {
        return this.f47739a.mo60195c();
    }

    /* renamed from: d */
    public void m60152d(View view) {
        this.f47739a.mo60184d(view);
    }

    /* renamed from: e */
    public C9610l m60153e() {
        return this.f47739a.mo60199f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C9625s0) {
            return C9368c.m58729a(this.f47739a, ((C9625s0) obj).f47739a);
        }
        return false;
    }

    /* renamed from: f */
    public C13504c m60154f(int i10) {
        return this.f47739a.mo60186g(i10);
    }

    @Deprecated
    /* renamed from: g */
    public C13504c m60155g() {
        return this.f47739a.mo60196i();
    }

    @Deprecated
    /* renamed from: h */
    public C13504c m60156h() {
        return this.f47739a.mo60201j();
    }

    public int hashCode() {
        k kVar = this.f47739a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    @Deprecated
    /* renamed from: i */
    public int m60157i() {
        return this.f47739a.mo60187k().f60773d;
    }

    @Deprecated
    /* renamed from: j */
    public int m60158j() {
        return this.f47739a.mo60187k().f60770a;
    }

    @Deprecated
    /* renamed from: k */
    public int m60159k() {
        return this.f47739a.mo60187k().f60772c;
    }

    @Deprecated
    /* renamed from: l */
    public int m60160l() {
        return this.f47739a.mo60187k().f60771b;
    }

    @Deprecated
    /* renamed from: m */
    public boolean m60161m() {
        return !this.f47739a.mo60187k().equals(C13504c.f60769e);
    }

    /* renamed from: n */
    public C9625s0 m60162n(int i10, int i11, int i12, int i13) {
        return this.f47739a.mo60188m(i10, i11, i12, i13);
    }

    /* renamed from: p */
    public boolean m60163p() {
        return this.f47739a.mo60197n();
    }

    @Deprecated
    /* renamed from: q */
    public C9625s0 m60164q(int i10, int i11, int i12, int i13) {
        return new b(this).m60172c(C13504c.m81228b(i10, i11, i12, i13)).m60170a();
    }

    /* renamed from: r */
    public void m60165r(C13504c[] c13504cArr) {
        this.f47739a.mo60190p(c13504cArr);
    }

    /* renamed from: s */
    public void m60166s(C13504c c13504c) {
        this.f47739a.mo60191q(c13504c);
    }

    /* renamed from: t */
    public void m60167t(C9625s0 c9625s0) {
        this.f47739a.mo60192r(c9625s0);
    }

    /* renamed from: u */
    public WindowInsets m60168u() {
        k kVar = this.f47739a;
        if (kVar instanceof f) {
            return ((f) kVar).f47753c;
        }
        return null;
    }

    /* renamed from: f0.s0$c */
    public static class c extends e {

        /* renamed from: c */
        public final WindowInsets.Builder f47745c;

        public c() {
            this.f47745c = new WindowInsets.Builder();
        }

        @Override // p273f0.C9625s0.e
        /* renamed from: b */
        public C9625s0 mo60173b() {
            m60179a();
            C9625s0 c9625s0M60147v = C9625s0.m60147v(this.f47745c.build());
            c9625s0M60147v.m60165r(this.f47747b);
            return c9625s0M60147v;
        }

        @Override // p273f0.C9625s0.e
        /* renamed from: c */
        public void mo60174c(C13504c c13504c) {
            this.f47745c.setMandatorySystemGestureInsets(c13504c.m81231e());
        }

        @Override // p273f0.C9625s0.e
        /* renamed from: d */
        public void mo60175d(C13504c c13504c) {
            this.f47745c.setStableInsets(c13504c.m81231e());
        }

        @Override // p273f0.C9625s0.e
        /* renamed from: e */
        public void mo60176e(C13504c c13504c) {
            this.f47745c.setSystemGestureInsets(c13504c.m81231e());
        }

        @Override // p273f0.C9625s0.e
        /* renamed from: f */
        public void mo60177f(C13504c c13504c) {
            this.f47745c.setSystemWindowInsets(c13504c.m81231e());
        }

        @Override // p273f0.C9625s0.e
        /* renamed from: g */
        public void mo60178g(C13504c c13504c) {
            this.f47745c.setTappableElementInsets(c13504c.m81231e());
        }

        public c(C9625s0 c9625s0) {
            WindowInsets.Builder builder;
            super(c9625s0);
            WindowInsets windowInsetsM60168u = c9625s0.m60168u();
            if (windowInsetsM60168u != null) {
                builder = new WindowInsets.Builder(windowInsetsM60168u);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f47745c = builder;
        }
    }

    /* renamed from: f0.s0$g */
    public static class g extends f {

        /* renamed from: m */
        public C13504c f47758m;

        public g(C9625s0 c9625s0, WindowInsets windowInsets) {
            super(c9625s0, windowInsets);
            this.f47758m = null;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: b */
        public C9625s0 mo60194b() {
            return C9625s0.m60147v(this.f47753c.consumeStableInsets());
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: c */
        public C9625s0 mo60195c() {
            return C9625s0.m60147v(this.f47753c.consumeSystemWindowInsets());
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: i */
        public final C13504c mo60196i() {
            if (this.f47758m == null) {
                this.f47758m = C13504c.m81228b(this.f47753c.getStableInsetLeft(), this.f47753c.getStableInsetTop(), this.f47753c.getStableInsetRight(), this.f47753c.getStableInsetBottom());
            }
            return this.f47758m;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: n */
        public boolean mo60197n() {
            return this.f47753c.isConsumed();
        }

        public g(C9625s0 c9625s0, g gVar) {
            super(c9625s0, gVar);
            this.f47758m = null;
            this.f47758m = gVar.f47758m;
        }
    }

    /* renamed from: f0.s0$f */
    public static class f extends k {

        /* renamed from: h */
        public static boolean f47748h = false;

        /* renamed from: i */
        public static Method f47749i;

        /* renamed from: j */
        public static Class<?> f47750j;

        /* renamed from: k */
        public static Field f47751k;

        /* renamed from: l */
        public static Field f47752l;

        /* renamed from: c */
        public final WindowInsets f47753c;

        /* renamed from: d */
        public C13504c[] f47754d;

        /* renamed from: e */
        public C13504c f47755e;

        /* renamed from: f */
        public C9625s0 f47756f;

        /* renamed from: g */
        public C13504c f47757g;

        public f(C9625s0 c9625s0, WindowInsets windowInsets) {
            super(c9625s0);
            this.f47755e = null;
            this.f47753c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: s */
        private C13504c m60180s(int i10, boolean z10) {
            C13504c c13504cM81227a = C13504c.f60769e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    c13504cM81227a = C13504c.m81227a(c13504cM81227a, m60193t(i11, z10));
                }
            }
            return c13504cM81227a;
        }

        /* renamed from: u */
        private C13504c m60181u() {
            C9625s0 c9625s0 = this.f47756f;
            return c9625s0 != null ? c9625s0.m60155g() : C13504c.f60769e;
        }

        /* renamed from: v */
        private C13504c m60182v(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f47748h) {
                m60183w();
            }
            Method method = f47749i;
            if (method != null && f47750j != null && f47751k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f47751k.get(f47752l.get(objInvoke));
                    if (rect != null) {
                        return C13504c.m81229c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        /* renamed from: w */
        private static void m60183w() throws ClassNotFoundException, SecurityException {
            try {
                f47749i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f47750j = cls;
                f47751k = cls.getDeclaredField("mVisibleInsets");
                f47752l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f47751k.setAccessible(true);
                f47752l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f47748h = true;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: d */
        public void mo60184d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            C13504c c13504cM60182v = m60182v(view);
            if (c13504cM60182v == null) {
                c13504cM60182v = C13504c.f60769e;
            }
            mo60191q(c13504cM60182v);
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: e */
        public void mo60185e(C9625s0 c9625s0) {
            c9625s0.m60167t(this.f47756f);
            c9625s0.m60166s(this.f47757g);
        }

        @Override // p273f0.C9625s0.k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f47757g, ((f) obj).f47757g);
            }
            return false;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: g */
        public C13504c mo60186g(int i10) {
            return m60180s(i10, false);
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: k */
        public final C13504c mo60187k() {
            if (this.f47755e == null) {
                this.f47755e = C13504c.m81228b(this.f47753c.getSystemWindowInsetLeft(), this.f47753c.getSystemWindowInsetTop(), this.f47753c.getSystemWindowInsetRight(), this.f47753c.getSystemWindowInsetBottom());
            }
            return this.f47755e;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: m */
        public C9625s0 mo60188m(int i10, int i11, int i12, int i13) {
            b bVar = new b(C9625s0.m60147v(this.f47753c));
            bVar.m60172c(C9625s0.m60146o(mo60187k(), i10, i11, i12, i13));
            bVar.m60171b(C9625s0.m60146o(mo60196i(), i10, i11, i12, i13));
            return bVar.m60170a();
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: o */
        public boolean mo60189o() {
            return this.f47753c.isRound();
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: p */
        public void mo60190p(C13504c[] c13504cArr) {
            this.f47754d = c13504cArr;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: q */
        public void mo60191q(C13504c c13504c) {
            this.f47757g = c13504c;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: r */
        public void mo60192r(C9625s0 c9625s0) {
            this.f47756f = c9625s0;
        }

        /* renamed from: t */
        public C13504c m60193t(int i10, boolean z10) {
            C13504c c13504cM60155g;
            int i11;
            if (i10 == 1) {
                return z10 ? C13504c.m81228b(0, Math.max(m60181u().f60771b, mo60187k().f60771b), 0, 0) : C13504c.m81228b(0, mo60187k().f60771b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    C13504c c13504cM60181u = m60181u();
                    C13504c c13504cMo60196i = mo60196i();
                    return C13504c.m81228b(Math.max(c13504cM60181u.f60770a, c13504cMo60196i.f60770a), 0, Math.max(c13504cM60181u.f60772c, c13504cMo60196i.f60772c), Math.max(c13504cM60181u.f60773d, c13504cMo60196i.f60773d));
                }
                C13504c c13504cMo60187k = mo60187k();
                C9625s0 c9625s0 = this.f47756f;
                c13504cM60155g = c9625s0 != null ? c9625s0.m60155g() : null;
                int iMin = c13504cMo60187k.f60773d;
                if (c13504cM60155g != null) {
                    iMin = Math.min(iMin, c13504cM60155g.f60773d);
                }
                return C13504c.m81228b(c13504cMo60187k.f60770a, 0, c13504cMo60187k.f60772c, iMin);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return mo60201j();
                }
                if (i10 == 32) {
                    return mo60200h();
                }
                if (i10 == 64) {
                    return mo60202l();
                }
                if (i10 != 128) {
                    return C13504c.f60769e;
                }
                C9625s0 c9625s02 = this.f47756f;
                C9610l c9610lM60153e = c9625s02 != null ? c9625s02.m60153e() : mo60199f();
                return c9610lM60153e != null ? C13504c.m81228b(c9610lM60153e.m60076b(), c9610lM60153e.m60078d(), c9610lM60153e.m60077c(), c9610lM60153e.m60075a()) : C13504c.f60769e;
            }
            C13504c[] c13504cArr = this.f47754d;
            c13504cM60155g = c13504cArr != null ? c13504cArr[l.m60203a(8)] : null;
            if (c13504cM60155g != null) {
                return c13504cM60155g;
            }
            C13504c c13504cMo60187k2 = mo60187k();
            C13504c c13504cM60181u2 = m60181u();
            int i12 = c13504cMo60187k2.f60773d;
            if (i12 > c13504cM60181u2.f60773d) {
                return C13504c.m81228b(0, 0, 0, i12);
            }
            C13504c c13504c = this.f47757g;
            return (c13504c == null || c13504c.equals(C13504c.f60769e) || (i11 = this.f47757g.f60773d) <= c13504cM60181u2.f60773d) ? C13504c.f60769e : C13504c.m81228b(0, 0, 0, i11);
        }

        public f(C9625s0 c9625s0, f fVar) {
            this(c9625s0, new WindowInsets(fVar.f47753c));
        }
    }

    /* renamed from: f0.s0$b */
    public static final class b {

        /* renamed from: a */
        public final e f47744a;

        public b() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f47744a = new d();
            } else {
                this.f47744a = new c();
            }
        }

        /* renamed from: a */
        public C9625s0 m60170a() {
            return this.f47744a.mo60173b();
        }

        @Deprecated
        /* renamed from: b */
        public b m60171b(C13504c c13504c) {
            this.f47744a.mo60175d(c13504c);
            return this;
        }

        @Deprecated
        /* renamed from: c */
        public b m60172c(C13504c c13504c) {
            this.f47744a.mo60177f(c13504c);
            return this;
        }

        public b(C9625s0 c9625s0) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f47744a = new d(c9625s0);
            } else {
                this.f47744a = new c(c9625s0);
            }
        }
    }

    /* renamed from: f0.s0$i */
    public static class i extends h {

        /* renamed from: n */
        public C13504c f47759n;

        /* renamed from: o */
        public C13504c f47760o;

        /* renamed from: p */
        public C13504c f47761p;

        public i(C9625s0 c9625s0, WindowInsets windowInsets) {
            super(c9625s0, windowInsets);
            this.f47759n = null;
            this.f47760o = null;
            this.f47761p = null;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: h */
        public C13504c mo60200h() {
            if (this.f47760o == null) {
                this.f47760o = C13504c.m81230d(this.f47753c.getMandatorySystemGestureInsets());
            }
            return this.f47760o;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: j */
        public C13504c mo60201j() {
            if (this.f47759n == null) {
                this.f47759n = C13504c.m81230d(this.f47753c.getSystemGestureInsets());
            }
            return this.f47759n;
        }

        @Override // p273f0.C9625s0.k
        /* renamed from: l */
        public C13504c mo60202l() {
            if (this.f47761p == null) {
                this.f47761p = C13504c.m81230d(this.f47753c.getTappableElementInsets());
            }
            return this.f47761p;
        }

        @Override // p273f0.C9625s0.f, p273f0.C9625s0.k
        /* renamed from: m */
        public C9625s0 mo60188m(int i10, int i11, int i12, int i13) {
            return C9625s0.m60147v(this.f47753c.inset(i10, i11, i12, i13));
        }

        public i(C9625s0 c9625s0, i iVar) {
            super(c9625s0, iVar);
            this.f47759n = null;
            this.f47760o = null;
            this.f47761p = null;
        }
    }

    public C9625s0(C9625s0 c9625s0) {
        if (c9625s0 != null) {
            k kVar = c9625s0.f47739a;
            if (Build.VERSION.SDK_INT >= 30 && (kVar instanceof j)) {
                this.f47739a = new j(this, (j) kVar);
            } else if (kVar instanceof i) {
                this.f47739a = new i(this, (i) kVar);
            } else if (kVar instanceof h) {
                this.f47739a = new h(this, (h) kVar);
            } else if (kVar instanceof g) {
                this.f47739a = new g(this, (g) kVar);
            } else if (kVar instanceof f) {
                this.f47739a = new f(this, (f) kVar);
            } else {
                this.f47739a = new k(this);
            }
            kVar.mo60185e(this);
            return;
        }
        this.f47739a = new k(this);
    }
}
