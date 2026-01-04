package p630s2;

import android.text.TextUtils;
import java.util.Collection;

/* renamed from: s2.k */
/* loaded from: classes.dex */
public final class C12676k {
    /* renamed from: a */
    public static void m76273a(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: b */
    public static String m76274b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    /* renamed from: c */
    public static <T extends Collection<Y>, Y> T m76275c(T t10) {
        if (t10.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t10;
    }

    /* renamed from: d */
    public static <T> T m76276d(T t10) {
        return (T) m76277e(t10, "Argument must not be null");
    }

    /* renamed from: e */
    public static <T> T m76277e(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
