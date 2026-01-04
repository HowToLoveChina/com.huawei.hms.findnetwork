package p692uw;

import java.util.Arrays;
import p408jw.C10950p;

/* renamed from: uw.j */
/* loaded from: classes9.dex */
public class C13267j {
    /* renamed from: a */
    public static boolean m79673a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: b */
    public static void m79674b(Object obj) {
        if (obj == null) {
            m79684l();
        }
    }

    /* renamed from: c */
    public static void m79675c(Object obj, String str) {
        if (obj == null) {
            m79685m(str);
        }
    }

    /* renamed from: d */
    public static void m79676d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m79681i(new NullPointerException(str + " must not be null")));
    }

    /* renamed from: e */
    public static void m79677e(Object obj, String str) {
        if (obj == null) {
            m79686n(str);
        }
    }

    /* renamed from: f */
    public static int m79678f(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    /* renamed from: g */
    public static String m79679g(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = C13267j.class.getName();
        int i10 = 0;
        while (!stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        while (stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    /* renamed from: h */
    public static void m79680h(int i10, String str) {
        m79687o();
    }

    /* renamed from: i */
    public static <T extends Throwable> T m79681i(T t10) {
        return (T) m79682j(t10, C13267j.class.getName());
    }

    /* renamed from: j */
    public static <T extends Throwable> T m79682j(T t10, String str) {
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        t10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
        return t10;
    }

    /* renamed from: k */
    public static String m79683k(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: l */
    public static void m79684l() {
        throw ((NullPointerException) m79681i(new NullPointerException()));
    }

    /* renamed from: m */
    public static void m79685m(String str) {
        throw ((NullPointerException) m79681i(new NullPointerException(str)));
    }

    /* renamed from: n */
    public static void m79686n(String str) {
        throw ((NullPointerException) m79681i(new NullPointerException(m79679g(str))));
    }

    /* renamed from: o */
    public static void m79687o() {
        m79688p("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* renamed from: p */
    public static void m79688p(String str) {
        throw new UnsupportedOperationException(str);
    }

    /* renamed from: q */
    public static void m79689q(String str) {
        throw ((C10950p) m79681i(new C10950p(str)));
    }

    /* renamed from: r */
    public static void m79690r(String str) {
        m79689q("lateinit property " + str + " has not been initialized");
    }
}
