package p640sq;

import java.lang.reflect.InvocationTargetException;

/* renamed from: sq.m */
/* loaded from: classes8.dex */
public class C12834m {
    /* renamed from: a */
    public static Object m77085a(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        m77087c(cls, clsArr, objArr);
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException e10) {
                C12836o.m77098c("HwInvoke", "IllegalAccessException" + e10.getClass().getSimpleName(), true);
                return null;
            } catch (IllegalArgumentException e11) {
                C12836o.m77098c("HwInvoke", "IllegalArgumentException" + e11.getClass().getSimpleName(), true);
                return null;
            } catch (InvocationTargetException e12) {
                C12836o.m77098c("HwInvoke", "InvocationTargetException" + e12.getClass().getSimpleName(), true);
                return null;
            }
        } catch (NoSuchMethodException e13) {
            C12836o.m77098c("HwInvoke", "NoSuchMethodException" + e13.getClass().getSimpleName(), true);
        } catch (Exception e14) {
            C12836o.m77098c("HwInvoke", "Exception" + e14.getClass().getSimpleName(), true);
        }
    }

    /* renamed from: b */
    public static Object m77086b(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return m77085a(Class.forName(str), str2, clsArr, objArr);
        } catch (ClassNotFoundException e10) {
            C12836o.m77098c("HwInvoke", "ClassNotFoundException" + e10.getClass().getSimpleName(), true);
            return null;
        } catch (Exception e11) {
            C12836o.m77098c("HwInvoke", "Exception" + e11.getClass().getSimpleName(), true);
            return null;
        } catch (Throwable th2) {
            C12836o.m77098c("HwInvoke", "Throwable" + th2.getClass().getSimpleName(), true);
            return null;
        }
    }

    /* renamed from: c */
    public static void m77087c(Class cls, Class[] clsArr, Object[] objArr) throws Exception {
        if (cls == null) {
            throw new ClassNotFoundException("class is null in staticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new ClassNotFoundException("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new ClassNotFoundException("paramsType or params should be same");
            }
            if (clsArr.length == objArr.length) {
                return;
            }
            throw new ClassNotFoundException("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
        }
    }
}
