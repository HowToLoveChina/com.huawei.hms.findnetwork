package p791xx;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: xx.g */
/* loaded from: classes9.dex */
public class C13892g<T> {

    /* renamed from: a */
    public final Class<?> f62227a;

    /* renamed from: b */
    public final String f62228b;

    /* renamed from: c */
    public final Class[] f62229c;

    public C13892g(Class<?> cls, String str, Class... clsArr) {
        this.f62227a = cls;
        this.f62228b = str;
        this.f62229c = clsArr;
    }

    /* renamed from: b */
    public static Method m83279b(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException, SecurityException {
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
    public final Method m83280a(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2;
        String str = this.f62228b;
        if (str == null) {
            return null;
        }
        Method methodM83279b = m83279b(cls, str, this.f62229c);
        if (methodM83279b == null || (cls2 = this.f62227a) == null || cls2.isAssignableFrom(methodM83279b.getReturnType())) {
            return methodM83279b;
        }
        return null;
    }

    /* renamed from: c */
    public Object m83281c(T t10, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodM83280a = m83280a(t10.getClass());
        if (methodM83280a == null) {
            throw new AssertionError("Method " + this.f62228b + " not supported for object " + t10);
        }
        try {
            return methodM83280a.invoke(t10, objArr);
        } catch (IllegalAccessException e10) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodM83280a);
            assertionError.initCause(e10);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object m83282d(T t10, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodM83280a = m83280a(t10.getClass());
        if (methodM83280a == null) {
            return null;
        }
        try {
            return methodM83280a.invoke(t10, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: e */
    public Object m83283e(T t10, Object... objArr) {
        try {
            return m83282d(t10, objArr);
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

    /* renamed from: f */
    public Object m83284f(T t10, Object... objArr) {
        try {
            return m83281c(t10, objArr);
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

    /* renamed from: g */
    public boolean m83285g(T t10) {
        return m83280a(t10.getClass()) != null;
    }
}
