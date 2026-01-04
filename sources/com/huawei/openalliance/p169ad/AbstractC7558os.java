package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7808da;

/* renamed from: com.huawei.openalliance.ad.os */
/* loaded from: classes8.dex */
public abstract class AbstractC7558os {
    /* renamed from: A */
    public static boolean m46453A(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 0, 2);
        return numM48266a != null && 1 == numM48266a.intValue();
    }

    /* renamed from: B */
    public static int m46454B(String str) {
        if (m46483v(str)) {
            return 3;
        }
        Integer numM48266a = AbstractC7808da.m48266a(str, 0, 2);
        if (numM48266a == null || !(numM48266a.intValue() == 1 || numM48266a.intValue() == 2)) {
            return 0;
        }
        return numM48266a.intValue();
    }

    /* renamed from: C */
    public static int m46455C(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 1, 1);
        if (numM48266a != null) {
            return numM48266a.intValue();
        }
        return 0;
    }

    /* renamed from: D */
    public static boolean m46456D(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 2, 1);
        return numM48266a != null && numM48266a.intValue() == 1;
    }

    /* renamed from: E */
    public static int m46457E(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 3, 1);
        if (numM48266a == null) {
            return 0;
        }
        return numM48266a.intValue();
    }

    /* renamed from: F */
    public static boolean m46458F(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 4, 1);
        return numM48266a != null && numM48266a.intValue() == 1;
    }

    /* renamed from: G */
    public static boolean m46459G(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 6, 1);
        return numM48266a != null && numM48266a.intValue() == 1;
    }

    /* renamed from: H */
    public static boolean m46460H(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 7, 1);
        return numM48266a != null && numM48266a.intValue() == 1;
    }

    /* renamed from: I */
    public static boolean m46461I(String str) {
        Integer numM48266a = AbstractC7808da.m48266a(str, 2, 2);
        return numM48266a == null || numM48266a.intValue() == 1;
    }

    /* renamed from: a */
    public static boolean m46462a(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 1);
        return numM48265a == null || 1 == numM48265a.intValue();
    }

    /* renamed from: b */
    public static boolean m46463b(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 2);
        return (numM48265a == null || numM48265a.intValue() == 0) ? false : true;
    }

    /* renamed from: c */
    public static boolean m46464c(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 0);
        return numM48265a == null || 1 == numM48265a.intValue();
    }

    /* renamed from: d */
    public static boolean m46465d(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 3);
        return (numM48265a == null || numM48265a.intValue() == 0) ? false : true;
    }

    /* renamed from: e */
    public static boolean m46466e(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 5);
        return numM48265a == null || 1 == numM48265a.intValue();
    }

    /* renamed from: f */
    public static int m46467f(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 17);
        if (numM48265a == null) {
            return 2;
        }
        return numM48265a.intValue();
    }

    /* renamed from: g */
    public static boolean m46468g(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 7);
        return numM48265a != null && 1 == numM48265a.intValue();
    }

    /* renamed from: h */
    public static boolean m46469h(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 9);
        return numM48265a == null || 1 == numM48265a.intValue();
    }

    /* renamed from: i */
    public static boolean m46470i(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 10);
        return numM48265a != null && 1 == numM48265a.intValue();
    }

    /* renamed from: j */
    public static int m46471j(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 11);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 2;
    }

    /* renamed from: k */
    public static boolean m46472k(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 12);
        return numM48265a != null && 1 == numM48265a.intValue();
    }

    /* renamed from: l */
    public static boolean m46473l(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 13);
        return numM48265a == null || 1 == numM48265a.intValue();
    }

    /* renamed from: m */
    public static boolean m46474m(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 14);
        return numM48265a != null && 1 == numM48265a.intValue();
    }

    /* renamed from: n */
    public static int m46475n(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 15);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 2;
    }

    /* renamed from: o */
    public static boolean m46476o(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 16);
        return numM48265a == null || 1 == numM48265a.intValue();
    }

    /* renamed from: p */
    public static boolean m46477p(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 16);
        return numM48265a != null && numM48265a.intValue() == 0;
    }

    /* renamed from: q */
    public static boolean m46478q(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 16);
        return numM48265a != null && 2 == numM48265a.intValue();
    }

    /* renamed from: r */
    public static boolean m46479r(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 18);
        return numM48265a != null && 1 == numM48265a.intValue();
    }

    /* renamed from: s */
    public static boolean m46480s(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 19);
        return numM48265a != null && 1 == numM48265a.intValue();
    }

    /* renamed from: t */
    public static int m46481t(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 20);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 1;
    }

    /* renamed from: u */
    public static boolean m46482u(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 21);
        return numM48265a != null && numM48265a.intValue() == 0;
    }

    /* renamed from: v */
    public static boolean m46483v(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 22);
        return numM48265a != null && 1 == numM48265a.intValue();
    }

    /* renamed from: w */
    public static boolean m46484w(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 23);
        return numM48265a == null || numM48265a.intValue() == 0;
    }

    /* renamed from: x */
    public static boolean m46485x(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 23);
        return numM48265a != null && numM48265a.intValue() == 1;
    }

    /* renamed from: y */
    public static boolean m46486y(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 23);
        return numM48265a != null && numM48265a.intValue() == 2;
    }

    /* renamed from: z */
    public static int m46487z(String str) {
        Integer numM48265a = AbstractC7808da.m48265a(str, 24);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 0;
    }
}
