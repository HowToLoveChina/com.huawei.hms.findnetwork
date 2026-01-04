package p828z0;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: z0.a */
/* loaded from: classes.dex */
public final class C14060a {

    /* renamed from: a */
    public static long f62849a;

    /* renamed from: b */
    public static Method f62850b;

    /* renamed from: a */
    public static void m84265a(String str) {
        C14061b.m84270a(str);
    }

    /* renamed from: b */
    public static void m84266b() {
        C14061b.m84271b();
    }

    /* renamed from: c */
    public static void m84267c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public static boolean m84268d() {
        try {
            if (f62850b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return m84269e();
    }

    /* renamed from: e */
    public static boolean m84269e() {
        try {
            if (f62850b == null) {
                f62849a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f62850b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f62850b.invoke(null, Long.valueOf(f62849a))).booleanValue();
        } catch (Exception e10) {
            m84267c("isTagEnabled", e10);
            return false;
        }
    }
}
