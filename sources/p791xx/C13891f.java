package p791xx;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.EnumC11914c0;

/* renamed from: xx.f */
/* loaded from: classes9.dex */
public final class C13891f extends C13893h {

    /* renamed from: c */
    public final Method f62225c;

    /* renamed from: d */
    public final Method f62226d;

    public C13891f(Method method, Method method2) {
        this.f62225c = method;
        this.f62226d = method2;
    }

    /* renamed from: u */
    public static C13891f m83278u() {
        try {
            return new C13891f(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: g */
    public void mo83244g(SSLSocket sSLSocket, String str, List<EnumC11914c0> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listM83286b = C13893h.m83286b(list);
            this.f62225c.invoke(sSLParameters, listM83286b.toArray(new String[listM83286b.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to set SSL parameters", e10);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: n */
    public String mo83245n(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f62226d.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
