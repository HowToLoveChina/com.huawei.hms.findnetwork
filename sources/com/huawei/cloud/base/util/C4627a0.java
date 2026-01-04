package com.huawei.cloud.base.util;

/* renamed from: com.huawei.cloud.base.util.a0 */
/* loaded from: classes.dex */
public final class C4627a0 {
    /* renamed from: a */
    public static void m28388a(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: b */
    public static void m28389b(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: c */
    public static void m28390c(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(m28396i(str, objArr));
        }
    }

    /* renamed from: d */
    public static <T> T m28391d(T t10) {
        t10.getClass();
        return t10;
    }

    /* renamed from: e */
    public static <T> T m28392e(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: f */
    public static <T> T m28393f(T t10, String str, Object... objArr) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(m28396i(str, objArr));
    }

    /* renamed from: g */
    public static void m28394g(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: h */
    public static void m28395h(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: i */
    public static String m28396i(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        }
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i10 = 0;
        int i11 = 0;
        while (i10 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i11)) != -1) {
            sb2.append((CharSequence) strValueOf, i11, iIndexOf);
            sb2.append(objArr[i10]);
            i11 = iIndexOf + 2;
            i10++;
        }
        sb2.append((CharSequence) strValueOf, i11, strValueOf.length());
        if (i10 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i10]);
            for (int i12 = i10 + 1; i12 < objArr.length; i12++) {
                sb2.append(", ");
                sb2.append(objArr[i12]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }
}
