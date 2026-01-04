package es;

import android.text.TextUtils;
import as.C1016d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: es.p */
/* loaded from: classes8.dex */
public class C9551p {

    /* renamed from: a */
    public static final String f47462a = "ReflectionUtils";

    /* renamed from: a */
    public static boolean m59637a(String str) {
        try {
            m59642f(str);
            return true;
        } catch (Exception unused) {
            C1016d.m6190j(f47462a, str + "ClassNotFoundException");
            return false;
        }
    }

    /* renamed from: b */
    public static Class<?> m59638b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            C1016d.m6183c(f47462a, "className not found:" + str);
            return null;
        }
    }

    /* renamed from: c */
    public static Method m59639c(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                C1016d.m6183c(f47462a, "getMethod NoSuchMethodException");
            }
        }
        return null;
    }

    /* renamed from: d */
    public static Object m59640d(Object obj, Method method, Object... objArr) {
        if (method == null) {
            throw new UnsupportedOperationException();
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            C1016d.m6183c(f47462a, "invoke Exception");
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: e */
    public static boolean m59641e(String str) {
        return m59638b(str) != null;
    }

    /* renamed from: f */
    public static void m59642f(String str) throws ClassNotFoundException {
        ClassLoader classLoader = C9551p.class.getClassLoader();
        if (classLoader == null) {
            throw new ClassNotFoundException("not found classloader");
        }
        classLoader.loadClass(str);
    }
}
