package p039bu;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* renamed from: bu.b */
/* loaded from: classes5.dex */
public class C1289b {
    /* renamed from: a */
    public static Object m7642a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        m7644c(cls, clsArr, objArr);
        try {
            try {
                try {
                    return cls.getMethod(str, clsArr).invoke(obj, objArr);
                } catch (IllegalAccessException e10) {
                    C1288a.m7641b("ReflectUtil", "IllegalAccessException" + e10.getMessage());
                    return null;
                } catch (InvocationTargetException e11) {
                    C1288a.m7641b("ReflectUtil", "InvocationTargetException" + e11.getMessage());
                    return null;
                }
            } catch (IllegalArgumentException e12) {
                C1288a.m7641b("ReflectUtil", "IllegalArgumentException" + e12.getMessage());
                return null;
            }
        } catch (NoSuchMethodException e13) {
            C1288a.m7641b("ReflectUtil", "NoSuchMethodException" + e13.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static Object m7643b(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Class<?> cls = Class.forName(str);
        return m7642a(cls, cls.newInstance(), str2, clsArr, objArr);
    }

    /* renamed from: c */
    public static void m7644c(Class cls, Class[] clsArr, Object[] objArr) throws Exception {
        if (cls == null) {
            throw new Exception("class is null in staticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new Exception("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new Exception("paramsType or params should be same");
            }
            if (clsArr.length == objArr.length) {
                return;
            }
            throw new Exception("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
        }
    }

    /* renamed from: d */
    public static boolean m7645d(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return z10;
        }
        try {
            Object objM7643b = m7643b("android.os.SystemProperties", "getBoolean", new Class[]{String.class, Boolean.TYPE}, new Object[]{str, Boolean.valueOf(z10)});
            if (objM7643b instanceof Boolean) {
                return ((Boolean) objM7643b).booleanValue();
            }
        } catch (Exception e10) {
            C1288a.m7641b("ReflectUtil", "getSystemPropertyBoolean, Excetion." + e10.getMessage());
        }
        return z10;
    }
}
