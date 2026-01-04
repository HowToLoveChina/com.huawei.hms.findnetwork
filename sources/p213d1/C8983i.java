package p213d1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import p320gz.C10072a;

/* renamed from: d1.i */
/* loaded from: classes.dex */
public class C8983i {

    /* renamed from: d1.i$a */
    public static class a {

        /* renamed from: a */
        public static final C8986l f45583a = new C8986l(C8983i.m56812d().getWebkitToCompatConverter());
    }

    /* renamed from: d1.i$b */
    public static class b {

        /* renamed from: a */
        public static final InterfaceC8984j f45584a = C8983i.m56809a();
    }

    /* renamed from: a */
    public static InterfaceC8984j m56809a() {
        try {
            return new C8985k((WebViewProviderFactoryBoundaryInterface) C10072a.m62693a(WebViewProviderFactoryBoundaryInterface.class, m56810b()));
        } catch (ClassNotFoundException unused) {
            return new C8979e();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    /* renamed from: b */
    public static InvocationHandler m56810b() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, m56813e()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]);
    }

    /* renamed from: c */
    public static C8986l m56811c() {
        return a.f45583a;
    }

    /* renamed from: d */
    public static InterfaceC8984j m56812d() {
        return b.f45584a;
    }

    /* renamed from: e */
    public static ClassLoader m56813e() {
        return C8976b.m56791b();
    }
}
