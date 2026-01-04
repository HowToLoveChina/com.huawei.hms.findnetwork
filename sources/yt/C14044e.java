package yt;

import android.content.Context;
import java.lang.reflect.Method;
import p787xt.C13865a;

/* renamed from: yt.e */
/* loaded from: classes5.dex */
public class C14044e {

    /* renamed from: a */
    public static Object f62828a;

    /* renamed from: b */
    public static Method f62829b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            f62829b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f62828a = method.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            C13865a.m83189c("Reflection", "reflect failed : " + th2.getMessage());
        }
    }

    /* renamed from: a */
    public static int m84248a(Context context) {
        return m84249b() ? 0 : -21;
    }

    /* renamed from: b */
    public static boolean m84249b() {
        return m84250c("L");
    }

    /* renamed from: c */
    public static boolean m84250c(String... strArr) {
        Method method;
        Object obj = f62828a;
        if (obj != null && (method = f62829b) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
