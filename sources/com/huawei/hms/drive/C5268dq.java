package com.huawei.hms.drive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.huawei.hms.drive.dq */
/* loaded from: classes8.dex */
class C5268dq<T> {

    /* renamed from: a */
    private final Class<?> f24488a;

    /* renamed from: b */
    private final String f24489b;

    /* renamed from: c */
    private final Class[] f24490c;

    public C5268dq(Class<?> cls, String str, Class... clsArr) {
        this.f24488a = cls;
        this.f24489b = str;
        this.f24490c = clsArr;
    }

    /* renamed from: a */
    public boolean m31683a(T t10) {
        return m31680a(t10.getClass()) != null;
    }

    /* renamed from: b */
    public Object m31684b(T t10, Object... objArr) {
        try {
            return m31682a(t10, objArr);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object m31685c(T t10, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodM31680a = m31680a(t10.getClass());
        if (methodM31680a == null) {
            throw new AssertionError("Method " + this.f24489b + " not supported for object " + t10);
        }
        try {
            return methodM31680a.invoke(t10, objArr);
        } catch (IllegalAccessException e10) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodM31680a);
            assertionError.initCause(e10);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object m31686d(T t10, Object... objArr) {
        try {
            return m31685c(t10, objArr);
        } catch (NullPointerException e10) {
            if ("ssl == null".equals(e10.getMessage())) {
                return null;
            }
            throw e10;
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    public Object m31682a(T t10, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodM31680a = m31680a(t10.getClass());
        if (methodM31680a == null) {
            return null;
        }
        try {
            return methodM31680a.invoke(t10, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private Method m31680a(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2;
        String str = this.f24489b;
        if (str == null) {
            return null;
        }
        Method methodM31681a = m31681a(cls, str, this.f24490c);
        if (methodM31681a == null || (cls2 = this.f24488a) == null || cls2.isAssignableFrom(methodM31681a.getReturnType())) {
            return methodM31681a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m31681a(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException, SecurityException {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
