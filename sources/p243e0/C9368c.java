package p243e0;

import java.util.Objects;

/* renamed from: e0.c */
/* loaded from: classes.dex */
public class C9368c {

    /* renamed from: e0.c$a */
    public static class a {
        /* renamed from: a */
        public static boolean m58734a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        /* renamed from: b */
        public static int m58735b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    /* renamed from: a */
    public static boolean m58729a(Object obj, Object obj2) {
        return a.m58734a(obj, obj2);
    }

    /* renamed from: b */
    public static int m58730b(Object... objArr) {
        return a.m58735b(objArr);
    }

    /* renamed from: c */
    public static <T> T m58731c(T t10) {
        t10.getClass();
        return t10;
    }

    /* renamed from: d */
    public static <T> T m58732d(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: e */
    public static String m58733e(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
