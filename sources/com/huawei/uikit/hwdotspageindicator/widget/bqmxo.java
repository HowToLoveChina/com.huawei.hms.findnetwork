package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.TimeInterpolator;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* loaded from: classes7.dex */
class bqmxo {

    /* renamed from: A */
    private static final float f42595A = -0.04f;

    /* renamed from: B */
    private static final float f42596B = 0.57f;

    /* renamed from: C */
    private static final float f42597C = 2.0f;

    /* renamed from: D */
    private static final float f42598D = 0.2f;

    /* renamed from: E */
    private static final float f42599E = 0.05f;

    /* renamed from: F */
    private static final float f42600F = 0.45f;

    /* renamed from: G */
    private static final float f42601G = 1.13f;

    /* renamed from: H */
    private static final float f42602H = 0.97f;

    /* renamed from: I */
    private static final float f42603I = 0.0f;

    /* renamed from: J */
    private static final float f42604J = 0.96f;

    /* renamed from: K */
    private static final float f42605K = 0.51f;

    /* renamed from: L */
    private static final float f42606L = 0.7f;

    /* renamed from: M */
    private static final float f42607M = 0.12f;

    /* renamed from: N */
    private static final float f42608N = 0.78f;

    /* renamed from: O */
    private static final float f42609O = 0.27f;

    /* renamed from: P */
    private static final int f42610P = 10;

    /* renamed from: Q */
    private static final int f42611Q = 2;

    /* renamed from: R */
    private static final int f42612R = 100;

    /* renamed from: S */
    private static final int f42613S = 5;

    /* renamed from: T */
    private static final int f42614T = -1;

    /* renamed from: U */
    private static final long f42615U = 100;

    /* renamed from: V */
    private static final long f42616V = 200;

    /* renamed from: W */
    private static long f42617W = 0;

    /* renamed from: X */
    private static boolean f42618X = false;

    /* renamed from: Y */
    private static boolean f42619Y = false;

    /* renamed from: a */
    private static final String f42620a = "HwIndicatorHelper";

    /* renamed from: b */
    private static final boolean f42621b = false;

    /* renamed from: c */
    private static final float f42622c = 1.0f;

    /* renamed from: d */
    private static final float f42623d = 0.0125f;

    /* renamed from: e */
    private static final float f42624e = 0.225f;

    /* renamed from: f */
    private static final float f42625f = 0.8f;

    /* renamed from: g */
    private static final float f42626g = 0.05f;

    /* renamed from: h */
    private static final float f42627h = 0.33f;

    /* renamed from: i */
    private static final float f42628i = 0.0f;

    /* renamed from: j */
    private static final float f42629j = 0.67f;

    /* renamed from: k */
    private static final float f42630k = 0.2f;

    /* renamed from: l */
    private static final float f42631l = 0.0f;

    /* renamed from: m */
    private static final float f42632m = 0.0f;

    /* renamed from: n */
    private static final float f42633n = 0.1f;

    /* renamed from: o */
    private static final float f42634o = 0.2f;

    /* renamed from: p */
    private static final float f42635p = 0.48f;

    /* renamed from: q */
    private static final float f42636q = 1.0f;

    /* renamed from: r */
    private static final float f42637r = 0.37f;

    /* renamed from: s */
    private static final float f42638s = 0.16f;

    /* renamed from: t */
    private static final float f42639t = 0.57f;

    /* renamed from: u */
    private static final float f42640u = 0.88f;

    /* renamed from: v */
    private static final float f42641v = 0.37f;

    /* renamed from: w */
    private static final float f42642w = 0.16f;

    /* renamed from: x */
    private static final float f42643x = 0.0f;

    /* renamed from: y */
    private static final float f42644y = 1.03f;

    /* renamed from: z */
    private static final float f42645z = 0.65f;

    public static class bzrwd {

        /* renamed from: a */
        private boolean f42646a = true;

        /* renamed from: b */
        private float f42647b;

        /* renamed from: c */
        private float f42648c;

        /* renamed from: d */
        private float f42649d;

        /* renamed from: e */
        private float f42650e;

        /* renamed from: f */
        private float f42651f;

        /* renamed from: a */
        public void m54613a(boolean z10) {
            this.f42646a = z10;
        }

        /* renamed from: b */
        public float m54614b() {
            return this.f42648c;
        }

        /* renamed from: c */
        public float m54616c() {
            return this.f42651f;
        }

        /* renamed from: d */
        public float m54618d() {
            return this.f42650e;
        }

        /* renamed from: e */
        public float m54620e() {
            return this.f42649d;
        }

        /* renamed from: f */
        public boolean m54622f() {
            return this.f42646a;
        }

        /* renamed from: a */
        public float m54611a() {
            return this.f42647b;
        }

        /* renamed from: b */
        public void m54615b(float f10) {
            this.f42648c = f10;
        }

        /* renamed from: c */
        public void m54617c(float f10) {
            this.f42651f = f10;
        }

        /* renamed from: d */
        public void m54619d(float f10) {
            this.f42650e = f10;
        }

        /* renamed from: e */
        public void m54621e(float f10) {
            this.f42649d = f10;
        }

        /* renamed from: a */
        public void m54612a(float f10) {
            this.f42647b = f10;
        }
    }

    private bqmxo() {
    }

    /* renamed from: a */
    public static Pair<Float, Float> m54595a(TimeInterpolator timeInterpolator, float f10, int i10, float f11, float f12) {
        return new Pair<>(Float.valueOf(f11 + ((f42624e - (Math.min(i10, 10) * f42623d)) * Math.abs(f10) * f11)), Float.valueOf((((1.0f - timeInterpolator.getInterpolation(f10)) * 0.19999999f) + 0.8f) * f12));
    }

    /* renamed from: b */
    public static TimeInterpolator m54599b() {
        return new HwCubicBezierInterpolator(f42627h, 0.0f, f42629j, 1.0f);
    }

    /* renamed from: c */
    public static TimeInterpolator m54601c() {
        return new HwCubicBezierInterpolator(1.0f, 0.0f, 1.0f, 1.0f);
    }

    /* renamed from: d */
    public static TimeInterpolator m54602d() {
        return new HwCubicBezierInterpolator(0.1f, 0.2f, f42635p, 1.0f);
    }

    /* renamed from: e */
    public static TimeInterpolator m54603e() {
        return new HwCubicBezierInterpolator(0.37f, 0.16f, 0.57f, f42640u);
    }

    /* renamed from: f */
    public static TimeInterpolator m54604f() {
        return new HwCubicBezierInterpolator(0.7f, f42607M, f42608N, f42609O);
    }

    /* renamed from: g */
    public static TimeInterpolator m54605g() {
        return new HwCubicBezierInterpolator(f42602H, 0.0f, f42604J, f42605K);
    }

    /* renamed from: h */
    public static TimeInterpolator m54606h() {
        return new HwCubicBezierInterpolator(0.37f, 0.16f, 0.0f, f42644y);
    }

    /* renamed from: i */
    public static TimeInterpolator m54607i() {
        return new HwCubicBezierInterpolator(0.2f, 0.05f, f42600F, f42601G);
    }

    /* renamed from: j */
    public static TimeInterpolator m54608j() {
        return new HwCubicBezierInterpolator(f42645z, f42595A, 0.57f, 2.0f);
    }

    /* renamed from: k */
    public static boolean m54609k() {
        return f42618X;
    }

    /* renamed from: l */
    public static boolean m54610l() {
        return f42619Y;
    }

    /* renamed from: b */
    public static boolean m54600b(bzrwd bzrwdVar, float f10, boolean z10, boolean z11, boolean z12) {
        float fM54611a = f10 - bzrwdVar.m54611a();
        if (Math.abs(fM54611a) < bzrwdVar.m54618d()) {
            return false;
        }
        return ((fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) > 0 && z12 && !z10) || ((fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) < 0 && z11 && !z10) || ((fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) < 0 && z12 && z10) || ((fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) > 0 && z11 && z10);
    }

    /* renamed from: a */
    public static int m54591a(int i10, float f10) {
        return (int) (f10 * (((f42624e - (Math.min(i10, 10) * f42623d)) * 2.0f) + 1.0f));
    }

    /* renamed from: a */
    public static float m54589a(float f10, float f11) {
        float f12 = f10 + (f11 * 0.05f);
        if (Float.compare(f12, 1.0f) >= 0) {
            return 0.95f;
        }
        return f12;
    }

    /* renamed from: a */
    public static float m54590a(TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2) {
        float f10 = 0.0f;
        if (timeInterpolator != null && timeInterpolator2 != null) {
            float f11 = 0.0f;
            for (int i10 = 0; i10 < 100; i10 += 5) {
                float f12 = i10 / 100.0f;
                float fAbs = Math.abs(timeInterpolator.getInterpolation(f12) - timeInterpolator2.getInterpolation(f12));
                if (fAbs > f11) {
                    f10 = f12;
                    f11 = fAbs;
                }
            }
        }
        return f10;
    }

    /* renamed from: a */
    public static TimeInterpolator m54593a() {
        return new HwCubicBezierInterpolator(0.2f, 0.0f, 1.0f, 1.0f);
    }

    /* renamed from: a */
    public static boolean m54598a(bzrwd bzrwdVar, float f10, boolean z10, boolean z11, boolean z12) {
        float fM54611a = f10 - bzrwdVar.m54611a();
        return (!z10 && z12 && (fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) > 0) || (z10 && z12 && (fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) < 0) || (!z10 && z11 && (fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) < 0) || (z10 && z11 && (fM54611a > 0.0f ? 1 : (fM54611a == 0.0f ? 0 : -1)) > 0);
    }

    /* renamed from: a */
    public static boolean m54597a(aauaf aauafVar, boolean z10, float f10, float f11) {
        float fM54568n = aauafVar.m54568n();
        float fM54570o = aauafVar.m54570o();
        float fM54563l = aauafVar.m54563l();
        float fM54561k = aauafVar.m54561k();
        return z10 ? f10 >= fM54563l && f10 < fM54568n && f11 >= fM54570o && f11 < fM54561k : f10 >= fM54568n && f10 < fM54563l && f11 >= fM54570o && f11 < fM54561k;
    }

    /* renamed from: a */
    public static int m54592a(aauaf aauafVar, float f10, float f11, float f12, float f13) {
        float[] fArrM54544e = aauafVar.m54544e();
        if (fArrM54544e == null) {
            return -1;
        }
        int length = fArrM54544e.length;
        for (int i10 = 0; i10 < length; i10++) {
            float fSqrt = (float) Math.sqrt(Math.pow(fArrM54544e[i10] - f12, 2.0d) + Math.pow(aauafVar.m54537d() - f13, 2.0d));
            if ((aauafVar.m54504B() == i10 && Float.compare(fSqrt, f10) <= 0) || Float.compare(fSqrt, f11) <= 0) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m54596a(boolean z10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j10 = f42617W;
        if (j10 == 0) {
            f42617W = jUptimeMillis;
            return;
        }
        if (!z10) {
            f42618X = false;
            f42619Y = false;
            return;
        }
        long j11 = jUptimeMillis - j10;
        if (j11 < 200) {
            f42619Y = true;
        } else {
            f42619Y = false;
        }
        if (j11 < f42615U) {
            f42618X = true;
        } else {
            f42618X = false;
        }
        f42617W = jUptimeMillis;
    }

    /* renamed from: a */
    public static Pair<Integer, Integer> m54594a(int i10, int i11, int i12, int i13) {
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            i12 = size;
        }
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i13 = Math.min(size2, i13);
        } else if (mode == 1073741824) {
            i13 = size2;
        }
        return new Pair<>(Integer.valueOf(i12), Integer.valueOf(i13));
    }
}
