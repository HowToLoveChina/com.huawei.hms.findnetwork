package com.huawei.uikit.hwcommon.utils;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class HwReflectUtil {

    /* renamed from: a */
    private static final String f42092a = "HwReflectUtil";

    private HwReflectUtil() {
    }

    public static Object callMethod(Object obj, String str, Class[] clsArr, Object[] objArr, Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            Log.e(f42092a, "IllegalAccessException in reflect call " + str);
            return null;
        } catch (IllegalArgumentException unused2) {
            Log.e(f42092a, "IllegalArgumentException in reflect call " + str);
            return null;
        } catch (NoSuchMethodException unused3) {
            Log.e(f42092a, "there is no " + str + " method");
            return null;
        } catch (InvocationTargetException unused4) {
            Log.e(f42092a, "InvocationTargetException in reflect call " + str);
            return null;
        }
    }

    public static int getInternalId(String str, String str2) throws NoSuchFieldException, SecurityException {
        try {
            Field field = Class.forName("com.android.internal.R$" + str).getField(str2);
            field.setAccessible(true);
            return field.getInt(null);
        } catch (ClassNotFoundException unused) {
            Log.e(f42092a, "getInternalId: com.android.internal.R." + str + " not found");
            return 0;
        } catch (IllegalAccessException unused2) {
            Log.e(f42092a, "getInternalId: IllegalAccessException of com.android.internal.R." + str + "." + str2);
            return 0;
        } catch (NoSuchFieldException unused3) {
            Log.e(f42092a, "getInternalId: com.android.internal.R." + str + "." + str2 + " not found");
            return 0;
        }
    }

    public static Method getMethod(String str, Class[] clsArr, String str2) {
        try {
            return getMethod(str, clsArr, Class.forName(str2));
        } catch (ClassNotFoundException unused) {
            Log.e(f42092a, "ClassNotFoundException in reflect call " + str);
            return null;
        }
    }

    public static Object getObject(Object obj, String str, Class<?> cls) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException unused) {
            Log.e(f42092a, "In get object, IllegalAccessException in reflect " + str);
            return null;
        } catch (NoSuchFieldException unused2) {
            Log.e(f42092a, "In get object, No field in reflect " + str);
            return null;
        }
    }

    public static Object invokeMethod(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            Log.e(f42092a, "IllegalAccessException in reflect call " + method.getName());
            return null;
        } catch (InvocationTargetException unused2) {
            Log.e(f42092a, "InvocationTargetException in reflect call " + method.getName());
            return null;
        }
    }

    public static void setObject(String str, Object obj, Object obj2, Class<?> cls) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException unused) {
            Log.e(f42092a, "In set object, IllegalAccessException in reflect " + str);
        } catch (IllegalArgumentException unused2) {
            Log.e(f42092a, "In set object, IllegalArgumentException in reflect " + str);
        } catch (NoSuchFieldException unused3) {
            Log.e(f42092a, "In set object, No field in reflect " + str);
        } catch (SecurityException unused4) {
            Log.e(f42092a, "In set object, SecurityException in reflect " + str);
        }
    }

    public static Method getMethod(String str, Class[] clsArr, Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            Log.e(f42092a, "there is no " + str + " method");
            return null;
        }
    }

    public static Object invokeMethod(Object obj, Method method) {
        return invokeMethod(obj, method, null);
    }

    public static Object invokeMethod(Method method) {
        return invokeMethod(null, method, null);
    }
}
