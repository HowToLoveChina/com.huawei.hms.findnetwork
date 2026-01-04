package p273f0;

import android.view.ViewGroup;

/* renamed from: f0.q */
/* loaded from: classes.dex */
public final class C9620q {

    /* renamed from: f0.q$a */
    public static class a {
        /* renamed from: a */
        public static int m60127a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        /* renamed from: b */
        public static int m60128b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        /* renamed from: c */
        public static int m60129c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        /* renamed from: d */
        public static boolean m60130d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        /* renamed from: e */
        public static void m60131e(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.resolveLayoutDirection(i10);
        }

        /* renamed from: f */
        public static void m60132f(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.setLayoutDirection(i10);
        }

        /* renamed from: g */
        public static void m60133g(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.setMarginEnd(i10);
        }

        /* renamed from: h */
        public static void m60134h(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.setMarginStart(i10);
        }
    }

    /* renamed from: a */
    public static int m60123a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.m60128b(marginLayoutParams);
    }

    /* renamed from: b */
    public static int m60124b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.m60129c(marginLayoutParams);
    }

    /* renamed from: c */
    public static void m60125c(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        a.m60133g(marginLayoutParams, i10);
    }

    /* renamed from: d */
    public static void m60126d(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        a.m60134h(marginLayoutParams, i10);
    }
}
