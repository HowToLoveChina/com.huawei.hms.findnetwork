package p481n1;

import java.util.concurrent.Callable;

/* renamed from: n1.j */
/* loaded from: classes.dex */
public class C11598j {

    /* renamed from: a */
    public static boolean f53832a = false;

    static {
        try {
            Class.forName("java.sql.Time");
            f53832a = true;
        } catch (Throwable unused) {
            f53832a = false;
        }
    }

    /* renamed from: a */
    public static <T> T m69232a(Callable<T> callable) {
        if (!f53832a) {
            return null;
        }
        try {
            return callable.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    /* renamed from: b */
    public static <T, U, R> R m69233b(InterfaceC11591c<T, U, R> interfaceC11591c, T t10, U u10) {
        if (f53832a) {
            return interfaceC11591c.apply(t10, u10);
        }
        return null;
    }

    /* renamed from: c */
    public static <ARG, T> T m69234c(InterfaceC11593e<ARG, T> interfaceC11593e, ARG arg) {
        if (f53832a) {
            return interfaceC11593e.apply(arg);
        }
        return null;
    }
}
