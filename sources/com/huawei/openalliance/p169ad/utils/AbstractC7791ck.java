package com.huawei.openalliance.p169ad.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.ck */
/* loaded from: classes2.dex */
public abstract class AbstractC7791ck {
    /* renamed from: a */
    public static Class m48054a(Field field) {
        int i10;
        if (field == null) {
            return null;
        }
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return m48055a(field, i10);
    }

    /* renamed from: b */
    public static boolean m48069b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (Throwable unused) {
            AbstractC7185ho.m43824c("ReflectAPI", "class not found for %s", str);
        }
        return ClassLoader.getSystemClassLoader().loadClass(str) != null;
    }

    /* renamed from: c */
    public static boolean m48070c(String str) throws ClassNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            AbstractC7185ho.m43824c("ReflectAPI", "class not found for %s", str);
            return false;
        }
    }

    /* renamed from: a */
    public static Class m48055a(Field field, int i10) throws ClassNotFoundException {
        Type[] actualTypeArguments;
        String str;
        Class<?> cls;
        if (field == null) {
            AbstractC7185ho.m43823c("ReflectAPI", "null field");
            return null;
        }
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) == null || actualTypeArguments.length <= i10) {
            return null;
        }
        try {
            Type type = actualTypeArguments[i10];
            if (type instanceof Class) {
                cls = (Class) type;
            } else {
                String string = type.toString();
                int iIndexOf = string.indexOf("class ");
                if (iIndexOf < 0) {
                    iIndexOf = 0;
                }
                int iIndexOf2 = string.indexOf("<");
                if (iIndexOf2 < 0) {
                    iIndexOf2 = string.length();
                }
                cls = Class.forName(string.substring(iIndexOf, iIndexOf2));
            }
            return cls;
        } catch (ClassNotFoundException unused) {
            str = "getType ClassNotFoundException";
            AbstractC7185ho.m43823c("ReflectAPI", str);
            return null;
        } catch (Exception unused2) {
            str = "getType Exception";
            AbstractC7185ho.m43823c("ReflectAPI", str);
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m48056a(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m48056a(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m48056a(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    /* renamed from: a */
    public static Object m48057a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        String str2;
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Method method = obj.getClass().getMethod(str, clsArr);
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeMethod IllegalAccessException";
                AbstractC7185ho.m43823c("ReflectAPI", str2);
                return null;
            } catch (NoSuchMethodException unused2) {
                str2 = "invokeMethod NoSuchMethodException";
                AbstractC7185ho.m43823c("ReflectAPI", str2);
                return null;
            } catch (SecurityException unused3) {
                str2 = "invokeMethod SecurityException";
                AbstractC7185ho.m43823c("ReflectAPI", str2);
                return null;
            } catch (InvocationTargetException unused4) {
                str2 = "invokeMethod InvocationTargetException";
                AbstractC7185ho.m43823c("ReflectAPI", str2);
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Field m48058a(Field field, boolean z10) throws SecurityException {
        if (field == null) {
            AbstractC7185ho.m43823c("ReflectAPI", "null field");
            return null;
        }
        field.setAccessible(z10);
        return field;
    }

    /* renamed from: a */
    public static Type m48059a(int i10, ParameterizedType parameterizedType) {
        if (parameterizedType == null) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i10 >= 0 && i10 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i10];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException(parameterizedType + ": index " + i10 + " not in range [0," + actualTypeArguments.length + ")");
    }

    /* renamed from: a */
    public static void m48060a(Object obj, String str) {
        StringBuilder sb2;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            for (String str3 : str.split("\\,")) {
                String[] strArrSplit = str3.split("\\|");
                m48064a(obj, strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "setBooleanValue RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "setBooleanValue Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m48061a(Object obj, String str, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb2;
        String str2;
        try {
            Method method = obj.getClass().getMethod(str, Integer.TYPE);
            method.setAccessible(true);
            method.invoke(obj, Integer.valueOf(i10));
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "setIntValue RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "setIntValue Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m48062a(Object obj, String str, long j10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb2;
        String str2;
        try {
            Method method = obj.getClass().getMethod(str, Long.TYPE);
            method.setAccessible(true);
            method.invoke(obj, Long.valueOf(j10));
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "setLongValue RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "setLongValue Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m48063a(Object obj, String str, String str2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb2;
        String str3;
        try {
            Method method = obj.getClass().getMethod(str, String.class);
            method.setAccessible(true);
            method.invoke(obj, str2);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "setStringValue RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "setStringValue Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m48064a(Object obj, String str, String str2, String str3) {
        StringBuilder sb2;
        String str4;
        try {
            if ("boolean".equals(str2)) {
                m48065a(obj, str, Boolean.parseBoolean(str3));
            } else if ("int".equals(str2)) {
                m48061a(obj, str, Integer.parseInt(str3));
            } else if ("long".equals(str2)) {
                m48062a(obj, str, Long.parseLong(str3, 10));
            } else if ("String".equals(str2)) {
                m48063a(obj, str, new String(Base64.decode(str3.getBytes(Constants.UTF_8), 0), Constants.UTF_8));
            }
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "setBooleanValue RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "setBooleanValue Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m48065a(Object obj, String str, boolean z10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb2;
        String str2;
        try {
            Method method = obj.getClass().getMethod(str, Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(obj, Boolean.valueOf(z10));
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "setBooleanValue RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "setBooleanValue Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ReflectAPI", sb2.toString());
        }
    }

    /* renamed from: a */
    public static boolean m48066a(String str) {
        return m48070c(str) || m48069b(str);
    }

    /* renamed from: a */
    public static boolean m48067a(String str, String str2, Class<?>[] clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class.forName(str).getDeclaredMethod(str2, clsArr);
                return true;
            } catch (ClassNotFoundException unused) {
                AbstractC7185ho.m43824c("ReflectAPI", "class not found for %s", str);
            } catch (NoSuchMethodException unused2) {
                AbstractC7185ho.m43824c("ReflectAPI", "method not found for %s", str2);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("ReflectAPI", "isMethodAvailable %s", th2.getClass().getSimpleName());
            }
        }
        return false;
    }

    /* renamed from: a */
    public static Field[] m48068a(Class cls) {
        if (cls == null) {
            AbstractC7185ho.m43823c("ReflectAPI", "null clazz");
            return null;
        }
        if (cls == Object.class) {
            return null;
        }
        Field[] fieldArrM48068a = cls.getSuperclass() != null ? m48068a(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (fieldArrM48068a == null || fieldArrM48068a.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + fieldArrM48068a.length];
        System.arraycopy(fieldArrM48068a, 0, fieldArr, 0, fieldArrM48068a.length);
        System.arraycopy(declaredFields, 0, fieldArr, fieldArrM48068a.length, declaredFields.length);
        return fieldArr;
    }
}
