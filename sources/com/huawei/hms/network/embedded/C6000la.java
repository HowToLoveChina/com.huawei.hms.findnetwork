package com.huawei.hms.network.embedded;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.huawei.hms.network.embedded.la */
/* loaded from: classes8.dex */
public class C6000la<T> {

    /* renamed from: a */
    public final Class<?> f27448a;

    /* renamed from: b */
    public final String f27449b;

    /* renamed from: c */
    public final Class[] f27450c;

    public C6000la(Class<?> cls, String str, Class... clsArr) {
        this.f27448a = cls;
        this.f27449b = str;
        this.f27450c = clsArr;
    }

    /* renamed from: a */
    public Object m34715a(T t10, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodM34713a = m34713a(t10.getClass());
        if (methodM34713a == null) {
            throw new AssertionError("Method " + this.f27449b + " not supported for object " + t10);
        }
        try {
            return methodM34713a.invoke(t10, objArr);
        } catch (IllegalAccessException e10) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodM34713a);
            assertionError.initCause(e10);
            throw assertionError;
        }
    }

    /* renamed from: b */
    public Object m34717b(T t10, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodM34713a = m34713a(t10.getClass());
        if (methodM34713a == null) {
            return null;
        }
        try {
            return methodM34713a.invoke(t10, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public Object m34718c(T t10, Object... objArr) {
        try {
            return m34717b(t10, objArr);
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

    /* renamed from: d */
    public Object m34719d(T t10, Object... objArr) {
        try {
            return m34715a(t10, objArr);
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
    private Method m34713a(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2;
        String str = this.f27449b;
        if (str == null) {
            return null;
        }
        Method methodM34714a = m34714a(cls, str, this.f27450c);
        if (methodM34714a == null || (cls2 = this.f27448a) == null || cls2.isAssignableFrom(methodM34714a.getReturnType())) {
            return methodM34714a;
        }
        return null;
    }

    /* renamed from: a */
    public static Method m34714a(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException, SecurityException {
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

    /* renamed from: a */
    public boolean m34716a(T t10) {
        return m34713a(t10.getClass()) != null;
    }
}
