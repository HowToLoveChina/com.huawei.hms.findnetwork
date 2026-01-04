package p243e0;

import android.text.TextUtils;
import java.util.Locale;

/* renamed from: e0.h */
/* loaded from: classes.dex */
public final class C9373h {
    /* renamed from: a */
    public static void m58740a(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: b */
    public static int m58741b(int i10, int i11, int i12, String str) {
        if (i10 < i11) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i11), Integer.valueOf(i12)));
        }
        if (i10 <= i12) {
            return i10;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i11), Integer.valueOf(i12)));
    }

    /* renamed from: c */
    public static int m58742c(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    public static int m58743d(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str);
    }

    /* renamed from: e */
    public static int m58744e(int i10, int i11) {
        if ((i10 & i11) == i10) {
            return i10;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(i11) + " are allowed");
    }

    /* renamed from: f */
    public static <T> T m58745f(T t10) {
        t10.getClass();
        return t10;
    }

    /* renamed from: g */
    public static <T> T m58746g(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: h */
    public static void m58747h(boolean z10, String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: i */
    public static <T extends CharSequence> T m58748i(T t10, Object obj) {
        if (TextUtils.isEmpty(t10)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t10;
    }
}
